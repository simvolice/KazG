package org.springframework.dao;

import org.springframework.model.DogovoraEntity;
import org.springframework.model.FilialyEntity;

import java.util.List;

/**
 * Created by Естай on 17.11.2014.
 */
public interface DogovoraDAO {

    public List<DogovoraEntity> getAllRecordsDogovora();

    public String addRecordsDogovora(DogovoraEntity entity);

    public String deleteRecordDogovora(DogovoraEntity filialyEntity);

    public DogovoraEntity findByIdDogovora(int id);

    public String updateRecordsDogovora(DogovoraEntity filialyEntity);


}
