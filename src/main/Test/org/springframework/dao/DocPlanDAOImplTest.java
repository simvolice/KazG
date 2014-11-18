package org.springframework.dao;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.model.DocPlanEntity;
import org.springframework.model.FilialyEntity;
import org.springframework.model.UsersEntity;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class DocPlanDAOImplTest {

    @Test
    public void testGetAllRecordsDocPlan() throws Exception {

    }

    @Test
    public void testAddRecordsDocPlan() throws Exception {



        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("resources/config/business-context.xml");
        ctx.refresh();


        DocPlanDAO docPlanDAO = ctx.getBean(DocPlanDAO.class);
        FilialyDAO filialyDAO = ctx.getBean(FilialyDAO.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);

        //filing docPlan
        DocPlanEntity docPlanEntity = new DocPlanEntity();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        docPlanEntity.setDate(timestamp);
        docPlanEntity.setYear(2015);




        // filling filial
        FilialyEntity filialyEntity = new FilialyEntity();
        filialyEntity = filialyDAO.findByIdFilialy(9);
        filialyEntity.addDocPlan(docPlanEntity);


        //filing user
        UsersEntity avtor = new UsersEntity();
        avtor = userDAO.findByIdUser(3);
        avtor.addDocPlan(docPlanEntity);

        String answer = docPlanDAO.addRecordsDocPlan(docPlanEntity);

    }

    @Test
    public void testDeleteRecordDocPlan() throws Exception {

    }

    @Test
    public void testFindByIdDocPlan() throws Exception {

    }

    @Test
    public void testUpdateRecordsDocPlan() throws Exception {

    }
}