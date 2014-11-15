package org.springframework.dao;

import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.model.UsersEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 15.11.2014.
 */

@Repository
public class DaoImpl implements Dao {


    @Autowired
    private SessionFactory sessionFactory;

    private SessionFactory getCurrentSession() {
        return sessionFactory;
    }



//    @Override
//    public String UserAunth(String usrName, String usrPass ) {
//
//
//        UsersEntity usersEntityName =
//                (UsersEntity) getCurrentSession().createQuery("from UsersEntity c where c.username=" + usrName);
//
//
//        if(usersEntityName.getUserpassword() == usrPass){
//            return "";
//        }
//
//
//        ResourceBundle bundle = ResourceBundle.getBundle("messages");
//
//        return  bundle.getString("ErrorName");
//    }








    @Override

    public String AddUser() {



        UsersEntity usersEntity = new UsersEntity();
usersEntity.setUseremail("dddd");
        usersEntity.setUserrole("ADMIN");


        usersEntity.setUserpassword("dfdfd");
        usersEntity.setUsername("sasha");
usersEntity.setUserlastname("dfdfdfd");
        usersEntity.setUserfirstname("dfdfdf");


        Session session = getCurrentSession().openSession();

        session.beginTransaction();
        session.save(usersEntity);
        session.getTransaction().commit();
        getCurrentSession().close();





        Locale currentLocale;
        currentLocale = new Locale("RU");
        ResourceBundle bundle = ResourceBundle.getBundle("messages.messages",currentLocale);

        return  bundle.getString("UsrAdd");
    }

    @Override
    public String DeleteUser(String usrName) {
        return "dfdfdf";
    }



}

