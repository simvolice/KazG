package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.ArticleEntity;
import org.springframework.model.ImageEntity;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String handleFileUpload(@RequestParam("rus") String ru, @RequestParam("en") String en, @RequestParam("kz") String kz,
                            @RequestParam("file") MultipartFile[] files) {


        if (files.length != 0) {

            try {
                ArticleEntity articleEntity = new ArticleEntity();
                articleEntity.setTextEng(en);
                articleEntity.setTextKz(kz);
                articleEntity.setTextRus(ru);

                int i = 0;

                for (MultipartFile fileOne : files) {


                    byte[] bytes = fileOne.getBytes();

                    i++;
                    String rootPath = System.getProperty("catalina.home");
                    File dir = new File(rootPath + File.separator + "tmpFiles");
                    if (!dir.exists())
                        dir.mkdirs();


                    // Create the file on server
                    File serverFile = new File(dir.getAbsolutePath()
                            + File.separator + fileOne.getOriginalFilename());
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();

                    ImageEntity imageEntity = new ImageEntity();

                    imageEntity.setImagesrc(bytes);


                    articleEntity.addImage(imageEntity);




                }

                mainService.addRecordsArticle(articleEntity);





                return "You successfullt loaded" + i + "files";

            } catch (Exception e) {
                return "Вам не удалось загрузить " + "files[i].getOriginalFilename()" + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + "fileOne.getOriginalFilename()" + " потому что файл пустой.";
        }
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
