package org.springframework.dao;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.model.DocPlanEntity;
import org.springframework.model.PlanbymonthesEntity;

import static org.junit.Assert.*;

public class PlanByMonthDAOImplTest {

    @Test
    public void testGetAllRecordsPlanByMonth() throws Exception {

    }

    @Test
    public void testAddRecordsPlanByMonth() throws Exception {




        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("resources/config/business-context.xml");
        ctx.refresh();


        PlanByMonthDAO planByMonthDAO = ctx.getBean(PlanByMonthDAO.class);
        PlanbymonthesEntity planByMonthes = new PlanbymonthesEntity();
        planByMonthes.setKolvoDogovorov(135);
        planByMonthes.setMonthName("January");

        DocPlanDAO docPlanDAO = ctx.getBean(DocPlanDAO.class);
        DocPlanEntity docPlanEntity = new DocPlanEntity();
        docPlanEntity = docPlanDAO.findByIdDocPlan(0);

        docPlanEntity.addPlanByMonth(planByMonthes);

        String answer = docPlanDAO.addRecordsDocPlan(docPlanEntity);



    }

    @Test
    public void testDeleteRecordPlanByMonth() throws Exception {

    }

    @Test
    public void testFindByIdPlanByMonth() throws Exception {

    }

    @Test
    public void testUpdateRecordsPlanByMonth() throws Exception {

    }
}