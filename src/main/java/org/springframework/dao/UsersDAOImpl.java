package org.springframework.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.domain.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Администратор on 10.11.2014.
 */

@Repository
public class UsersDAOImpl implements UserDAO {

    private Log log= LogFactory.getLog(FilialyDAOImpl.class);

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
    public List<UsersEntity> getAllRecordsUserEntity() {
        return currentSession().createQuery("from UsersEntity c").list();
    }

    @Override
    public void addRecordsUsers(UsersEntity usersEntity) {
        currentSession().saveOrUpdate(usersEntity);


    }

    @Override
    public void deleteRecordUsers(UsersEntity usersEntity) {



        currentSession().delete(usersEntity);

    }

    @Override
    public UsersEntity findByIdUser(int id) {
        UsersEntity usersEntity= (UsersEntity)currentSession().createQuery("from UsersEntity c where c.id =:id").setParameter("id", id).uniqueResult();


        if (usersEntity.getDocUslugi().size()==0){
            usersEntity.getDocUslugi().clear();
        }
        if (usersEntity.getDocPlanEntities().size()==0){
            usersEntity.getDocPlanEntities().clear();
        }

        return usersEntity;
    }

    @Override
    public String updateRecordsUsers(UsersEntity usersEntity) {
        currentSession().saveOrUpdate(usersEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }
}
