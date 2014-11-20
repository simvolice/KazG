package org.springframework.dao;

import org.springframework.model.DogovoraEntity;
import org.springframework.model.PlanbymonthesEntity;

import java.util.List;

/**
 * Created by Естай on 18.11.2014.
 */
public interface PlanByMonthDAO {

    public List<PlanbymonthesEntity> getAllRecordsPlanByMonth();

    public String addRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity);

    public String deleteRecordPlanByMonth(PlanbymonthesEntity planbymonthesEntity);

    public PlanbymonthesEntity findByIdPlanByMonth(int id);

    public String updateRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity);


}
