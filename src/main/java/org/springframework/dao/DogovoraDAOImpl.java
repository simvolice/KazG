package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DogovoraEntity;
import org.springframework.model.FilialyEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 17.11.2014.
 */
@Repository
public class DogovoraDAOImpl implements DogovoraDAO {

    //sesstion initialization






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

    // functions started


    @Override
    @Transactional
    public List<DogovoraEntity> getAllRecordsDogovora() {
        return currentSession().createQuery("from DogovoraEntity c").list();
    }

    @Override
    @Transactional
    public String addRecordsDogovora(DogovoraEntity dogovoraEntity) {
        currentSession().saveOrUpdate(dogovoraEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("AddRowSuccess");
    }

    @Override
    @Transactional
    public String deleteRecordDogovora(DogovoraEntity dogovoraEntity) {
        currentSession().delete(dogovoraEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");
    }

    @Override
    @Transactional
    public DogovoraEntity findByIdDogovora(int id) {

        DogovoraEntity dogovoraEntity= (DogovoraEntity)currentSession().createQuery("from DogovoraEntity c where c.id =:id").setParameter("id", id).uniqueResult();

        return dogovoraEntity;
    }

    @Override
    @Transactional
    public String updateRecordsDogovora(DogovoraEntity dogovoraEntity) {

        currentSession().saveOrUpdate(dogovoraEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }
}
