package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.ArticleEntity;
import org.springframework.service.MainService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 23.12.2014.
 */



@RestController
@RequestMapping("/data")
public class JsonController {

    private final MainService mainService;


    @Autowired
   public JsonController (MainService mainService) {

        this.mainService = mainService;

    }



    @RequestMapping("/getArt")
    @ResponseBody
    public  ArticleEntity articleEntity(@RequestParam(value = "id",required = false,
            defaultValue = "0") Integer id) {


        ArticleEntity articleEntity = mainService.findByIdArticleEntity(id);

       return articleEntity;



    }



}
