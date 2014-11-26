package org.springframework.controller;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.UsersEntity;
import org.springframework.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 26.11.2014.
 */


@Controller
@RequestMapping("/report/")
public class JasperController {

    private final MainService mainService;

    @Autowired
    public JasperController(MainService mainService) {

        this.mainService = mainService;

    }



    @RequestMapping(method = RequestMethod.GET , value = "pdf")
    public ModelAndView generatePdfReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<UsersEntity> usersList = mainService.getAllRecordsUserEntity();

        JRDataSource datasource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", datasource);

        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<UsersEntity> usersList = mainService.getAllRecordsUserEntity();

        JRDataSource datasource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", datasource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);

        return modelAndView;

    }//generatePdfReport


    @RequestMapping(method = RequestMethod.GET , value = "csv")
    public ModelAndView generateCsvReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<UsersEntity> usersList = mainService.getAllRecordsUserEntity();

        JRDataSource datasource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", datasource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);

        return modelAndView;

    }//generatePdfReport



    @RequestMapping(method = RequestMethod.GET , value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){



        Map<String,Object> parameterMap = new HashMap<String,Object>();

        List<UsersEntity> usersList = mainService.getAllRecordsUserEntity();

        JRDataSource datasource = new JRBeanCollectionDataSource(usersList);

        parameterMap.put("datasource", datasource);

        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);

        return modelAndView;

    }//generatePdfReport









}
