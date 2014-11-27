package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.FilialyEntity;
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
@SessionAttributes(types = FilialyEntity.class)

public class filController {






        private final MainService mainService;

        @Autowired
        public filController(MainService mainService) {

            this.mainService = mainService;

        }

    @RequestMapping(value = "/filials", method = RequestMethod.GET) //Метод GET
    public String initCreationForm(Model model) {



        List<FilialyEntity> filialyEntities = this.mainService.getAllRecordsFilialy();


        model.addAttribute("filialyEntities",filialyEntities);

        FilialyEntity filialyEntity = new FilialyEntity();
        model.addAttribute(filialyEntity);
        return "filials";
    }


    @RequestMapping(value = "/filials", method = RequestMethod.POST) //Method POST
    public String processCreationFormFil(@ModelAttribute("filialyEntity") FilialyEntity filialyEntity,BindingResult result, SessionStatus status) {





        this.mainService.addRecordsFilialy(filialyEntity);
        status.setComplete();
        return "redirect:/filials";

    }



}
