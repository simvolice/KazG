package org.springframework.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.UsersEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/config/business-context.xml")
public class UserDAOImplTest {


    @Autowired
    private SessionFactory sessionFactory;
    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }


    @Test
    @Transactional
    public void testUserAunth() throws Exception {



        UsersEntity usersEntity =
                (UsersEntity)  getSessionFactory().createQuery("from UsersEntity c where c.username= 'sasha'").uniqueResult();



         Assert.assertEquals("dfdfd",usersEntity.getUsername());






    }

    @Test
    public void testAddUser() throws Exception {







    }

    @Test
    public void testDeleteUser() throws Exception {






    }

    @Test
    @Transactional
    public void testGetAllUsers() throws Exception {

        List<UsersEntity> usersEntityName = getSessionFactory().createQuery("from UsersEntity").list();

        UsersEntity usersEntity = new UsersEntity();


        for(UsersEntity d:usersEntityName) {


            Assert.assertEquals(usersEntity,d);


        }



    }
}