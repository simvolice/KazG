package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.UslugiEntity;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

/**
 * Created by user on 27.11.2014.
 */
@Controller
@SessionAttributes(types = UslugiEntity.class)
public class uslugiController {



    private final MainService mainService;

    @Autowired
    public uslugiController(MainService mainService) {

        this.mainService = mainService;

    }

    @RequestMapping(value = "/uslugi", method = RequestMethod.GET) //Метод GET
    public String initCreationForm(Model model) {



        List<UslugiEntity> uslugiEntities = this.mainService.getAllRecordsUslugi();


        model.addAttribute("uslugiEntities",uslugiEntities);

        UslugiEntity uslugiEntity = new UslugiEntity();
        model.addAttribute(uslugiEntity);
        return "uslugi";
    }



    @RequestMapping(value = "/uslugi", method = RequestMethod.POST) //Method POST
    public String processCreationUslugi(@ModelAttribute("uslugiEntity") UslugiEntity uslugiEntity,BindingResult result, SessionStatus status) {





        this.mainService.addRecordsUslugi(uslugiEntity);
        status.setComplete();
        return "redirect:/uslugi";

    }



}
