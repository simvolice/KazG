package org.springframework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.domain.Entity;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.model.*;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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



        DocCreateUslDAO docCreateUslDAO = ctx.getBean(DocCreateUslDAO.class);
        FilialyDAO filialyDAO = ctx.getBean(FilialyDAO.class);
        DogovoraDAO dogovoraDAO = ctx.getBean(DogovoraDAO.class);
        UslugiDAO uslugiDAO = ctx.getBean(UslugiDAO.class);
        KontragentyDAO kontragentyDAO = ctx.getBean(KontragentyDAO.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
//       List<DocCreateUslEntity> docCreateUslEntity;
//
//        docCreateUslEntity = docCreateUslDAO.getAllRecordsDocCreateUsl();
//
//        listContacts(docCreateUslEntity);


        // zapolnenie doc create uslugi
        DocCreateUslEntity docUslugiDocument = new DocCreateUslEntity();
        //java.sql.Timestamp date = new Timestamp();
        //Timestamp timestamp = new Timestamp(date.getTime("2014-11-17"));
//        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-11-18 16:29:31");
//        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());


        Timestamp timestamp = new Timestamp(new Date().getTime());


        docUslugiDocument.setDate(timestamp);
        docUslugiDocument.setStoimost(774411000.00);


        // zapolnenie filial
        FilialyEntity filialyEntity = new FilialyEntity();
        filialyEntity = filialyDAO.findByIdFilialy(9);
        filialyEntity.addDocUslugi(docUslugiDocument);

        // userid

        UsersEntity usersEntity = new UsersEntity();
        usersEntity = userDAO.findByIdUser(4);
        usersEntity.addDocUslugi(docUslugiDocument);

        //dogovor

        DogovoraEntity dogovoraEntity = new DogovoraEntity();
        dogovoraEntity = dogovoraDAO.findByIdDogovora(1);
        dogovoraEntity.addDocUslugi(docUslugiDocument);

        //Uslugi
        UslugiEntity uslugiEntity = new UslugiEntity();
        uslugiEntity = uslugiDAO.findByIdUslugi(1);
        uslugiEntity.addDocUslugi(docUslugiDocument);

        //kontragenty
        KontragentEntity kontragentEntity = new KontragentEntity();
        kontragentEntity = kontragentyDAO.findByIdKontragenty(1);
        kontragentEntity.addDocUslugi(docUslugiDocument);

        //save all entties
//        String answer;
//        answer = filialyDAO.updateRecordsFilialy(filialyEntity);
//        System.out.println(answer);
//        answer = userDAO.updateRecordsUsers(usersEntity);
//        System.out.println(answer);
//        answer = dogovoraDAO.updateRecordsDogovora(dogovoraEntity);
//        System.out.println(answer);
//        answer = uslugiDAO.updateRecordsUslugi(uslugiEntity);
//        System.out.println(answer);
//        answer = kontragentyDAO.updateRecordsKontragenty(kontragentEntity);
//        System.out.println(answer);
//        answer = docCreateUslDAO.addRecordsDocCreateUsl(docUslugiDocument);
//        System.out.println(answer);

        //add records to doc create usl




    }
    private static void listContacts(List<DocCreateUslEntity> filialyEntities ){
        System.out.println("");
        System.out.println("Listing contacts without details: ");
        for(DocCreateUslEntity usersEntity: filialyEntities){
            System.out.print(usersEntity.getUsersEntity().getUsername());
            System.out.print(usersEntity.getDogovoraEntity().getSumma());
            System.out.print(usersEntity.getFilialyEntity().getNaimenovanie());
            System.out.println();
        }
    }
}