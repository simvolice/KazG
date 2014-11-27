package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DogovoraEntity;
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
@SessionAttributes(types = DogovoraEntity.class)
public class DogController {




    private final MainService mainService;

    @Autowired
    public DogController(MainService mainService) {

        this.mainService = mainService;

    }



    @RequestMapping(value = "/dogovora", method = RequestMethod.GET) //Метод GET
    public String initCreationForm(Model model) {



        List<DogovoraEntity> dogovoraEntities = this.mainService.getAllRecordsDogovora();


        model.addAttribute("dogovoraEntities",dogovoraEntities);

        DogovoraEntity dogovoraEntity = new DogovoraEntity();
        model.addAttribute(dogovoraEntity);
        return "dogovora";
    }




    @RequestMapping(value = "/dogovora", method = RequestMethod.POST) //Method POST
    public String processCreationFormDogovora(@ModelAttribute("dogovoraEntity") DogovoraEntity dogovoraEntity,BindingResult result, SessionStatus status) {





        this.mainService.addRecordsDogovora(dogovoraEntity);
        status.setComplete();
        return "redirect:/dogovora";

    }









}
