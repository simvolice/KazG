package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.KontragentEntity;
import org.springframework.model.UslugiEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 17.11.2014.
 */
@Repository
public class UslugiDAOImpl implements UslugiDAO {

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
    @Transactional
    public List<UslugiEntity> getAllRecordsUslugi() {
        return currentSession().createQuery("from UslugiEntity c").list();
    }

    @Override
    @Transactional
    public String addRecordsUslugi(UslugiEntity uslugiEntity) {
        currentSession().saveOrUpdate(uslugiEntity);
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
    public String deleteRecordUslugi(UslugiEntity uslugiEntity) {
        currentSession().delete(uslugiEntity);
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
    public UslugiEntity findByIdUslugi(int id) {
        UslugiEntity uslugiEntity= (UslugiEntity)currentSession().createQuery("from UslugiEntity c where c.id =:id").setParameter("id", id).uniqueResult();

        if (uslugiEntity.getDocUslugi().size()==0){
            uslugiEntity.getDocUslugi().clear();
        }

        return uslugiEntity;
    }

    @Override
    @Transactional
    public String updateRecordsUslugi(UslugiEntity uslugiEntity) {
        currentSession().saveOrUpdate(uslugiEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }

}
