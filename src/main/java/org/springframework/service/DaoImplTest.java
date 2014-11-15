package org.springframework.service;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.model.UsersEntity;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/business-context.xml")

public class DaoImplTest {




@Autowired
private SessionFactory sessionFactory;





    @Test

    public void testAddUser() throws Exception {


        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUseremail("dddd");
        usersEntity.setUserrole("ADMIN");


        usersEntity.setUserpassword("dfdfd");
        usersEntity.setUsername("sasha");
        usersEntity.setUserlastname("dfdfdfd");
        usersEntity.setUserfirstname("dfdfdf");




//        sessionFactory.getCurrentSession().save(usersEntity);



        Session session = sessionFactory.getCurrentSession();


org.junit.Assert.assertNotNull(session);


    }
}