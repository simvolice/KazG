package org.springframework.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DocCreateUslEntity;
import org.springframework.model.FilialyEntity;
import org.springframework.model.UsersEntity;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/report/")
public class ReportController {




    private final MainService mainService;

    @Autowired
    public ReportController(MainService mainService) {

        this.mainService = mainService;

    }

    @RequestMapping(method = RequestMethod.GET , value = "pdf")
    public ModelAndView generatePdfReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();







        List<FilialyEntity> userslist = this.mainService.getAllRecordsFilialy();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(userslist);

        parameterMap.put("datasource", JRdataSource);

        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    /*@RequestMapping(method = RequestMethod.GET , value = "xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


    @RequestMapping(method = RequestMethod.GET , value = "csv")
    public ModelAndView generateCsvReport(ModelAndView modelAndView){


        Map<String,Object> parameterMap = new HashMap<String,Object>();

//        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();

//        List<User> usersList = userDao.retrieveAllRegisteredUsers();

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", JRdataSource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);

        return modelAndView;

    }//generatePdfReport

*/
}//ReportController
