package org.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Администратор on 17.11.2014.
 */
@Controller
public class MainController {


    // Login form
    @RequestMapping("/login.html")
    public String login() {
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login.html")
    public String loginError(Model model) {
        model.addAttribute("login", true);
        return "login.html";
    }









}
