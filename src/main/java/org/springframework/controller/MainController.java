package org.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.model.*;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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



    @RequestMapping("/filials")
    public String gelAllRecordsFilial(Model uimodel){

        List<FilialyEntity> filialyEntityList = this.mainService.getAllRecordsFilialy();

        uimodel.addAttribute("filials", filialyEntityList);

        return "filials";
    }
















    @RequestMapping("/kontra")
    public String getAllRecordsKontra(Model uimodel){

        List<KontragentEntity> kontragentEntities = this.mainService.getAllRecordsKontragenty();

        uimodel.addAttribute("kontragent", kontragentEntities);

        return "kontra";
    }

    @RequestMapping("/uslugi")
    public String getAllRecordsUslugi(Model uimodel){

        List<UslugiEntity> uslugiEntities = this.mainService.getAllRecordsUslugi();

        uimodel.addAttribute("uslugi", uslugiEntities);

        return "uslugi";
    }


    @RequestMapping("/plan")
    public String getAllRecordsPlan(Model uimodel){

        List<DocPlanEntity> docPlanEntities = this.mainService.getAllRecordsDocPlan();

        uimodel.addAttribute("plan", docPlanEntities);

        return "plan";
    }


    @RequestMapping("/dogovora")
    public String getAllRecordsDogovora(Model uimodel){

        List<DogovoraEntity> dogovoraEntities = this.mainService.getAllRecordsDogovora();

        uimodel.addAttribute("dogovora", dogovoraEntities);

        return "dogovora";
    }

    @RequestMapping("/doc")
    public String getAllRecordsDocUslugi(Model uimodel){

        List<DocCreateUslEntity> docCreateUslEntities = this.mainService.getAllRecordsDocCreateUsl();

        uimodel.addAttribute("doc", docCreateUslEntities);

        return "doc";
    }

    @RequestMapping("/user")
    public String getAllRecordsUser(Model uimodel){

        List<UsersEntity> usersEntities = this.mainService.getAllRecordsUserEntity();

        uimodel.addAttribute("users", usersEntities);

        return "user";
    }

}
