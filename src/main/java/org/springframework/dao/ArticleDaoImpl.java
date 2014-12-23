package org.springframework.dao;

import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.model.ArticleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 22.12.2014.
 */
@Repository
public class ArticleDaoImpl implements ArticleDAO {

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
    public List<ArticleEntity> getAllArticle() {
        return currentSession().createQuery("from ArticleEntity c").list();
    }

    @Override
    public void addRecordsArticle(ArticleEntity articleEntity) {
        currentSession().saveOrUpdate(articleEntity);


    }

    @Override
    public String deleteRecordArticle(ArticleEntity articleEntity) {
        currentSession().delete(articleEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("DeleteRowSuccess");
    }

    @Override
    public ArticleEntity findByIdArticle(int id) {
        ArticleEntity articleEntity= (ArticleEntity)currentSession().createQuery("from ArticleEntity c where c.id =:id").setParameter("id", id).uniqueResult();

        if (articleEntity.getImageEntities().size()==0){
            articleEntity.getImageEntities().clear();
        }

        return articleEntity;
    }

    @Override
    public String updateRecordsArticle(ArticleEntity articleEntity) {
        currentSession().saveOrUpdate(articleEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }

}
