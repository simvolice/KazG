package org.springframework.dao;

import org.springframework.model.DocCreateUslEntity;
import org.springframework.model.DocPlanEntity;

import java.util.List;

/**
 * Created by Естай on 18.11.2014.
 */
public interface DocPlanDAO {

    public List<DocPlanEntity> getAllRecordsDocPlan();

    public String addRecordsDocPlan(DocPlanEntity docPlanEntity);

    public String deleteRecordDocPlan(DocPlanEntity docPlanEntity);

    public DocPlanEntity findByIdDocPlan(int id);

    public String updateRecordsDocPlan(DocPlanEntity docPlanEntity);


}
