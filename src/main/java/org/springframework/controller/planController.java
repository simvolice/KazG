package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DocPlanEntity;
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
@SessionAttributes(types = DocPlanEntity.class)
public class planController {









        private final MainService mainService;

        @Autowired
        public planController(MainService mainService) {

            this.mainService = mainService;

        }




    @RequestMapping(value = "/plan", method = RequestMethod.GET) //Метод GET
    public String initCreationForm(Model model) {



        List<DocPlanEntity> docPlanEntities = this.mainService.getAllRecordsDocPlan();


        model.addAttribute("docPlanEntities",docPlanEntities);

        DocPlanEntity docPlanEntity = new DocPlanEntity();
        model.addAttribute(docPlanEntity);
        return "plan";
    }











    @RequestMapping(value = "/plan", method = RequestMethod.POST) //Method POST
    public String processCreationPlan(@ModelAttribute("docPlanEntity") DocPlanEntity docPlanEntity,BindingResult result, SessionStatus status) {





        this.mainService.addRecordsDocPlan(docPlanEntity);
        status.setComplete();
        return "redirect:/plan";

    }



}
