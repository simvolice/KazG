package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DocCreateUslEntity;
import org.springframework.model.FilialyEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 16.11.2014.
 */
@Repository
public class FilialyDAOImpl implements FilialyDAO {

    private org.apache.commons.logging.Log log= LogFactory.getLog(FilialyDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    //@Resource(name = "sessionFactory")
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //@Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory= sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public String addRecordsFilialy(FilialyEntity filialyEntity) {

        currentSession().saveOrUpdate(filialyEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("AddRowSuccess");

    }




    @Override
    public String updateRecordsFilialy(FilialyEntity filialyEntity) {

        currentSession().saveOrUpdate(filialyEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");

    }


    @Override
    public String deleteRecordFilialy(FilialyEntity filialyEntity) {


        currentSession().delete(filialyEntity);

        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");

    }

    @Override
    public FilialyEntity findByIdFilialy(int id) {
        FilialyEntity filialyEntity = (FilialyEntity)currentSession().createQuery("from FilialyEntity c where c.id =:id").setParameter("id", id).uniqueResult();

        if (filialyEntity.getDocUslugi().size()==0){
            filialyEntity.getDocUslugi().clear();
        }
        if (filialyEntity.getDocPlanEntities().size()==0){
            filialyEntity.getDocPlanEntities().clear();
        }
        return filialyEntity;
    }

    @Override
    public List<FilialyEntity> getAllRecordsFilialy() {

        return currentSession().createQuery("from FilialyEntity c").list();

    }
}
