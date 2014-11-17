package org.springframework.dao;

import org.hibernate.metamodel.domain.Entity;
import org.springframework.model.FilialyEntity;
import org.springframework.model.UsersEntity;;

import java.util.List;

/**
 * Created by Естай on 16.11.2014.
 */
public interface FilialyDAO {

    public List<FilialyEntity> getAllRecordsFilialy();

    public String addRecordsFilialy(FilialyEntity entity);

    public String deleteRecordFilialy(FilialyEntity filialyEntity);

    public FilialyEntity findByIdFilialy(int id);

    public String updateRecordsFilialy(FilialyEntity filialyEntity);


}
