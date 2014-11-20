package org.springframework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DocCreateUslEntity;
import org.springframework.model.DocPlanEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 18.11.2014.
 */
@Repository
public class DocPlanDAOImpl implements DocPlanDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //@Resource(name = "sessionFactory")
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }


    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }



    @Override
    public List<DocPlanEntity> getAllRecordsDocPlan() {

        return currentSession().createQuery("from DocPlanEntity c").list();



    }

    @Override
    public String addRecordsDocPlan(DocPlanEntity docPlanEntity) {
        currentSession().saveOrUpdate(docPlanEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("AddRowSuccess");
    }

    @Override
    public String deleteRecordDocPlan(DocPlanEntity docPlanEntity) {
        currentSession().delete(docPlanEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");
    }

    @Override
    public DocPlanEntity findByIdDocPlan(int id) {
        DocPlanEntity docPlanEntity= (DocPlanEntity)currentSession().createQuery("from DocPlanEntity c where c.id =:id").setParameter("id", id).uniqueResult();


        if (docPlanEntity.getPlanByMonth().size() == 0){
            docPlanEntity.getPlanByMonth().clear();
        }

        return docPlanEntity;
    }

    @Override
    public String updateRecordsDocPlan(DocPlanEntity docPlanEntity) {
        currentSession().saveOrUpdate(docPlanEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }

}
