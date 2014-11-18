package org.springframework.dao;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.model.DogovoraEntity;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class DogovoraDAOTest {

    @Test
    public void testGetAllRecordsDogovora() throws Exception {

    }

    @Test
    public void testAddRecordsDogovora() throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("resources/config/business-context.xml");
        ctx.refresh();

        DogovoraDAO dogovoraDAO = ctx.getBean(DogovoraDAO.class);
        DogovoraEntity dogovoraEntity = new DogovoraEntity();


        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");

        String parameter = "2014-03-22";

        java.util.Date myDate = formatter.parse(parameter);
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

        dogovoraEntity.setStartDate(sqlDate);

        parameter = "2015-11-17";

        myDate = formatter.parse(parameter);
        sqlDate = new java.sql.Date(myDate.getTime());
            


        dogovoraEntity.setEndDate(sqlDate);
        dogovoraEntity.setSumma(1000);
        String answer = dogovoraDAO.addRecordsDogovora(dogovoraEntity);
        System.out.println(answer);

    }

    @Test
    public void testDeleteRecordDogovora() throws Exception {

    }

    @Test
    public void testFindByIdDogovora() throws Exception {

    }
}