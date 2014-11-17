package org.springframework.dao;

import org.springframework.model.DocCreateUslEntity;
import org.springframework.model.DogovoraEntity;

import java.util.List;

/**
 * Created by Естай on 17.11.2014.
 */
public interface DocCreateUslDAO {

    public List<DocCreateUslEntity> getAllRecordsDocCreateUsl();

    public String addRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity);

    public String deleteRecordDocCreateUsl(DocCreateUslEntity docCreateUslEntity);

    public DocCreateUslEntity findByIdDocCreateUsl(int id);

    public String updateRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity);
}
