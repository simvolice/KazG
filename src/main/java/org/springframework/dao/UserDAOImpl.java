package org.springframework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.UsersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 15.11.2014.
 */

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;





    @Override
    public String UserAunth(String usrName, String usrPass ) {


        UsersEntity usersEntityName =
                (UsersEntity) getSessionFactory().createQuery("from UsersEntity c where c.username=" + usrName).uniqueResult();


        if(usersEntityName.getUserpassword() == usrPass){
            return "";
        }



        getSessionFactory().close();


        ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", Locale.getDefault());
        return  bundle.getString("ErrorName");
    }








    @Override

    public String AddUser(UsersEntity usersEntity) {


getSessionFactory().saveOrUpdate(usersEntity);


        getSessionFactory().close();



        ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", Locale.getDefault());
        return  bundle.getString("UsrAdd");
    }

    @Override
    public String DeleteUser(Integer usrId) {


        UsersEntity usersEntity = (UsersEntity)getSessionFactory().createQuery("from UsersEntity c where c.id =" + usrId).uniqueResult();


        getSessionFactory().delete(usersEntity);


        getSessionFactory().close();




        ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", Locale.getDefault());

        return  bundle.getString("UsrDelete");
    }

    @Override
    public List<UsersEntity> GetAllUsers() {



        return getSessionFactory().createQuery("from UsersEntity").list();






    }


    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }


}

