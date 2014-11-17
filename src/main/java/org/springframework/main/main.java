package org.springframework.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.*;
import org.springframework.model.*;

import java.sql.Timestamp;
import java.util.Date;

public class main{
    public static void main(String[] args) {

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

        Timestamp timestamp = new Timestamp(new Date().getTime());

        docUslugiDocument.setDate(timestamp);
        docUslugiDocument.setStoimost(774411000.00);


        // zapolnenie filial
        FilialyEntity filialyEntity = new FilialyEntity();
        filialyEntity = filialyDAO.findByIdFilialy(9);
        // UserServiceImpl k = new UserServiceImpl();
        // k.insertDataFilial(9, docUslugiDocument);

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
        String answer;
        answer = filialyDAO.updateRecordsFilialy(filialyEntity);
        System.out.println(answer);
        answer = userDAO.updateRecordsUsers(usersEntity);
        System.out.println(answer);
        answer = dogovoraDAO.updateRecordsDogovora(dogovoraEntity);
        System.out.println(answer);
        answer = uslugiDAO.updateRecordsUslugi(uslugiEntity);
        System.out.println(answer);
        answer = kontragentyDAO.updateRecordsKontragenty(kontragentEntity);
        System.out.println(answer);
        answer = docCreateUslDAO.addRecordsDocCreateUsl(docUslugiDocument);
        System.out.println(answer);





    }


}
