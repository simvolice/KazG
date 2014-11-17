package org.springframework.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.DocCreateUslEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Естай on 17.11.2014.
 */
@Repository
public class DocCreateUslDAOImpl implements DocCreateUslDAO {


    @Autowired
    private SessionFactory sessionFactory;

    //@Resource(name = "sessionFactory")
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }


    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<DocCreateUslEntity> getAllRecordsDocCreateUsl() {


        return currentSession().createQuery("from DocCreateUslEntity c").list();








    }

    @Override
    @Transactional
    public String addRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity) {

        currentSession().saveOrUpdate(docCreateUslEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("AddRowSuccess");
    }

    @Override
    public String deleteRecordDocCreateUsl(DocCreateUslEntity docCreateUslEntity) {
        return null;
    }

    @Override
    public DocCreateUslEntity findByIdDocCreateUsl(int id) {
        return null;
    }

    @Override
    public String updateRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity) {
        return null;
    }
}
