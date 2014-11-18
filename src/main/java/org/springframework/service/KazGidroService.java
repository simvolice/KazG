package org.springframework.service;

import org.springframework.model.*;

import java.util.List;

/**
 * Created by Естай on 11.11.2014.
 */
public interface KazGidroService {

     // Doc Crate uslugi DAO
     public List<DocCreateUslEntity> getAllRecordsDocCreateUsl();

     public String addRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity);

     public String deleteRecordDocCreateUsl(DocCreateUslEntity docCreateUslEntity);

     public DocCreateUslEntity findByIdDocCreateUsl(int id);

     public String updateRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity);

     //Doc Plan DAO

     public List<DocPlanEntity> getAllRecordsDocPlan();

     public String addRecordsDocPlan(DocPlanEntity docPlanEntity);

     public String deleteRecordDocPlan(DocPlanEntity docPlanEntity);

     public DocPlanEntity findByIdDocPlan(int id);

     public String updateRecordsDocPlan(DocPlanEntity docPlanEntity);

     //Dogovora dao

     public List<DogovoraEntity> getAllRecordsDogovora();

     public String addRecordsDogovora(DogovoraEntity entity);

     public String deleteRecordDogovora(DogovoraEntity filialyEntity);

     public DogovoraEntity findByIdDogovora(int id);

     public String updateRecordsDogovora(DogovoraEntity filialyEntity);

     //  Filialy  DAO
     public List<FilialyEntity> getAllRecordsFilialy();

     public String addRecordsFilialy(FilialyEntity entity);

     public String deleteRecordFilialy(FilialyEntity filialyEntity);

     public FilialyEntity findByIdFilialy(int id);

     public String updateRecordsFilialy(FilialyEntity filialyEntity);


     //Kontragenty DAO
     public List<KontragentEntity> getAllRecordsKontragenty();

     public String addRecordsKontragenty(KontragentEntity kontragentEntity);

     public String deleteRecordKontragenty(KontragentEntity kontragentEntity);

     public KontragentEntity findByIdKontragenty(int id);

     public String updateRecordsKontragenty(KontragentEntity kontragentEntity);

     //Plan by month DAO
     public List<PlanbymonthesEntity> getAllRecordsPlanByMonth();

     public String addRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity);

     public String deleteRecordPlanByMonth(PlanbymonthesEntity planbymonthesEntity);

     public PlanbymonthesEntity findByIdPlanByMonth(int id);

     public String updateRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity);

     // User dao

     public List<UsersEntity> getAllRecordsUserEntity();

     public String addRecordsUsers(UsersEntity usersEntity);

     public String deleteRecordUsers(UsersEntity usersEntity);

     public UsersEntity findByIdUser(int id);

     public String updateRecordsUsers(UsersEntity usersEntity);


     //Uslugi DAO
     public List<UslugiEntity> getAllRecordsUslugi();

     public String addRecordsUslugi(UslugiEntity uslugiEntity);

     public String deleteRecordUslugi(UslugiEntity uslugiEntity);

     public UslugiEntity findByIdUslugi(int id);

     public String updateRecordsUslugi(UslugiEntity uslugiEntity);

}
