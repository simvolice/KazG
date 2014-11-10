package org.springframework.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.UsersEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Администратор on 10.11.2014.
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    private SessionFactory  sessionFactory;

    @Autowired
    public UsersDAOImpl(SessionFactory  sessionFactory) {

this.sessionFactory = sessionFactory;


    }


    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }






    @Override
    public Collection<UsersEntity> findAll() throws DataAccessException {

      return currentSession().createQuery("").list();



    }
}
