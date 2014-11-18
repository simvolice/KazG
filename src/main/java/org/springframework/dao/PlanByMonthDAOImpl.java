package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.KontragentEntity;
import org.springframework.model.PlanbymonthesEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 18.11.2014.
 */
@Repository
public class PlanByMonthDAOImpl implements PlanByMonthDAO {
    //sesstion initialization

    private org.apache.commons.logging.Log log= LogFactory.getLog(KontragentyDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory= sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<PlanbymonthesEntity> getAllRecordsPlanByMonth() {
        return currentSession().createQuery("from PlanbymonthesEntity c").list();
    }

    @Override
    public String addRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity) {
        currentSession().saveOrUpdate(planbymonthesEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("AddRowSuccess");
    }

    @Override
    public String deleteRecordPlanByMonth(PlanbymonthesEntity planbymonthesEntity) {
        currentSession().delete(planbymonthesEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");
    }

    @Override
    public PlanbymonthesEntity findByIdPlanByMonth(int id) {
        PlanbymonthesEntity planbymonthesEntity= (PlanbymonthesEntity)currentSession().createQuery("from PlanbymonthesEntity c where c.id =:id").setParameter("id", id).uniqueResult();

        return planbymonthesEntity;
    }

    @Override
    public String updateRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity) {
        currentSession().saveOrUpdate(planbymonthesEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }
}
