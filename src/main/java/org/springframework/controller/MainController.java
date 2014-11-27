package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Администратор on 17.11.2014.
 */
@Controller

public class MainController {


    private final MainService mainService;

   @Autowired
   public MainController(MainService mainService) {

        this.mainService = mainService;

    }








    @RequestMapping("/")
    public String root(Locale locale) {

        return "redirect:/login";

    }


    @RequestMapping("/index")
    public String index(Locale locale) {

        return "index";

    }



    @RequestMapping("/report")
    public String report(Locale locale){

        return "report";

    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout,
                              HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {

            model.addObject("error", "Invalid username and password!");

        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");


        }

model.setViewName("login");
        return model;

    }










}
