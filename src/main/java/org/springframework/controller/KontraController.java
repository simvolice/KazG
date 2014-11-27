package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.KontragentEntity;
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
@SessionAttributes(types = KontragentEntity.class)
public class KontraController {

    private final MainService mainService;

    @Autowired
    public KontraController(MainService mainService) {

        this.mainService = mainService;

    }







    @RequestMapping(value = "/kontra", method = RequestMethod.GET) //Метод GET
    public String initCreationForm(Model model) {



        List<KontragentEntity> kontragentEntities = this.mainService.getAllRecordsKontragenty();


        model.addAttribute("kontragentEntities",kontragentEntities);

        KontragentEntity kontragentEntity = new KontragentEntity();
        model.addAttribute(kontragentEntity);
        return "kontra";
    }



    @RequestMapping(value = "/kontra", method = RequestMethod.POST) //Method POST
    public String processCreationKontra(@ModelAttribute("kontragentEntity") KontragentEntity kontragentEntity,BindingResult result, SessionStatus status) {





        this.mainService.addRecordsKontragenty(kontragentEntity);
        status.setComplete();
        return "redirect:/kontra";

    }





}
