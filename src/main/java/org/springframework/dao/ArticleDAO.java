package org.springframework.dao;

import org.springframework.model.ArticleEntity;

import java.util.List;

/**
 * Created by user on 21.12.2014.
 */
public interface ArticleDAO {

    public List<ArticleEntity> getAllArticle();

    public void addRecordsArticle(ArticleEntity articleEntity);

    public String deleteRecordArticle(ArticleEntity articleEntity);

    public ArticleEntity findByIdArticle(int id);

    public String updateRecordsArticle(ArticleEntity articleEntity);

}
