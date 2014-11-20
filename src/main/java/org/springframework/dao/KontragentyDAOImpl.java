package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DogovoraEntity;
import org.springframework.model.KontragentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 17.11.2014.
 */
@Repository
public class KontragentyDAOImpl implements KontragentyDAO {

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

    // functions started


    @Override
    public List<KontragentEntity> getAllRecordsKontragenty() {
        return currentSession().createQuery("from KontragentEntity c").list();
    }

    @Override
    public String addRecordsKontragenty(KontragentEntity kontragentEntity) {

        currentSession().saveOrUpdate(kontragentEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("AddRowSuccess");


    }

    @Override
    public String deleteRecordKontragenty(KontragentEntity kontragentEntity) {
        currentSession().delete(kontragentEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");
    }

    @Override
    public KontragentEntity findByIdKontragenty(int id) {
        KontragentEntity kontragentEntity= (KontragentEntity)currentSession().createQuery("from KontragentEntity c where c.id =:id").setParameter("id", id).uniqueResult();


        if (kontragentEntity.getDocUslugi().size()==0){
            kontragentEntity.getDocUslugi().clear();
        }

        return kontragentEntity;
    }

    @Override
    public String updateRecordsKontragenty(KontragentEntity kontragentEntity) {
        currentSession().saveOrUpdate(kontragentEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }
}
