package org.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * Created by Администратор on 17.11.2014.
 */
@Controller
public class MainController {


    @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/login";
    }



    /** Home page. */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }









}
