package org.springframework.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.model.UsersEntity;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * Created by user on 23.11.2014.
 */
@Controller
@SessionAttributes(types = UserController.class)
public class UserController {




    private final MainService mainService;

    @Autowired
    public UserController(MainService mainService) {

        this.mainService = mainService;

    }



    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String initCreationForm(Model model) {



        List<UsersEntity> usersEntities = this.mainService.getAllRecordsUserEntity();


       model.addAttribute("usersEntities",usersEntities);

        UsersEntity usersEntity = new UsersEntity();
        model.addAttribute(usersEntity);
        return "user";
    }




    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("usersEntity") UsersEntity usersEntity,BindingResult result, SessionStatus status) {



            this.mainService.addRecordsUsers(usersEntity);
            status.setComplete();
            return "redirect:/user";



    }









}
