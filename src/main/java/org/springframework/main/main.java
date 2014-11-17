package org.springframework.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DAO;
import org.springframework.model.KontragentEntity;
import org.springframework.model.UsersEntity;
import org.springframework.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Естай on 12.11.2014.
 */
public class main{
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:root-context.xml");
        ctx.refresh();


    }


}
