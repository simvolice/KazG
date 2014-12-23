package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.ImageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 22.12.2014.
 */
@Repository
public class ImageDaoImpl implements ImageDao {
    private org.apache.commons.logging.Log log= LogFactory.getLog(FilialyDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    //@Resource(name = "sessionFactory")
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    //@Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory= sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public List<ImageEntity> getAllRecordsImage() {
        return currentSession().createQuery("from DogovoraEntity c").list();
    }

    @Override
    public void addRecordsImage(ImageEntity imageEntity) {
        currentSession().save(imageEntity);

    }

    @Override
    public String deleteRecordImage(ImageEntity imageEntity) {
        currentSession().delete(imageEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");
    }

    @Override
    public ImageEntity findByIdImage(int id) {
        ImageEntity imageEntity= (ImageEntity)currentSession().createQuery("from ImageEntity c where c.id =:id").setParameter("id", id).uniqueResult();

        return imageEntity;
    }

    @Override
    public String updateRecordsImage(ImageEntity imageEntity) {
        currentSession().saveOrUpdate(imageEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }
}
