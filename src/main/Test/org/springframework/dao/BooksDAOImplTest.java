package org.springframework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.domain.Entity;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.model.DocCreateUslEntity;
import org.springframework.model.FilialyEntity;
import org.springframework.model.UsersEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class BooksDAOImplTest {





    @Test
    @Transactional
    public void testAddRecordsBooks() throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("resources/config/business-context.xml");
        ctx.refresh();


        FilialyDAO bookstest = ctx.getBean(FilialyDAO.class);
        FilialyEntity filialyEntity = new FilialyEntity();
        filialyEntity.setNaimenovanie("New firm of mULLA");
        String answer = null;
        answer = bookstest.addRecordsBooks(filialyEntity);
        System.out.println(answer);
        //List<FilialyEntity> users= bookstest.readAllRecordsBook(filialyEntity);
        //listContacts(users);
//
//        FilialyEntity filialyEntity = new FilialyEntity();
//        filialyEntity.setNaimenovanie("Compania Yesa");
//
//
//
//        Set<DocCreateUslEntity> docCreateUslEntities = new HashSet<DocCreateUslEntity>();
//
//
//
//        filialyEntity.setDocUslugi(docCreateUslEntities);


    }
    private static void listContacts(List<FilialyEntity> filialyEntities ){
        System.out.println("");
        System.out.println("Listing contacts without details: ");
        for(FilialyEntity usersEntity: filialyEntities){
            System.out.println(usersEntity.getNaimenovanie());
            System.out.println();
        }
    }
}