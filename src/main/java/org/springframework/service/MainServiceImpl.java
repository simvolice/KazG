package org.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.*;
import org.springframework.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Естай on 18.11.2014.
 */
@Service
public class MainServiceImpl implements MainService {

    // initialization of DAO classes
    private DocCreateUslDAO docCreateUslDAO;
    private DocPlanDAO docPlanDAO;
    private DogovoraDAO dogovoraDAO;
    private FilialyDAO filialyDAO;
    private KontragentyDAO kontragentyDAO;
//    private PlanByMonthDAO planByMonthDAO;
    private UserDAO userDAO;
    private UslugiDAO uslugiDAO;


    @Autowired
    public MainServiceImpl(DocCreateUslDAO docCreateUslDAO, DocPlanDAO docPlanDAO,
                               DogovoraDAO dogovoraDAO, FilialyDAO filialyDAO,
                               KontragentyDAO kontragentyDAO,
                               UserDAO userDAO,  UslugiDAO uslugiDAO) {
        this.docCreateUslDAO = docCreateUslDAO;
        this.docPlanDAO = docPlanDAO;
        this.dogovoraDAO = dogovoraDAO;
        this.filialyDAO = filialyDAO;
        this.kontragentyDAO = kontragentyDAO;
//        this.planByMonthDAO = planByMonthDAO;
        this.userDAO = userDAO;
        this.uslugiDAO = uslugiDAO;
    }





    @Override
    @Transactional
    public List<DocCreateUslEntity> getAllRecordsDocCreateUsl() {
        return docCreateUslDAO.getAllRecordsDocCreateUsl();
    }

    @Override
    @Transactional
    public String addRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity) {
        return docCreateUslDAO.addRecordsDocCreateUsl(docCreateUslEntity);
    }

    @Override
    @Transactional
    public String deleteRecordDocCreateUsl(DocCreateUslEntity docCreateUslEntity) {
        return docCreateUslDAO.deleteRecordDocCreateUsl(docCreateUslEntity);
    }

    @Override
    @Transactional
    public DocCreateUslEntity findByIdDocCreateUsl(int id) {
        return docCreateUslDAO.findByIdDocCreateUsl(id);
    }

    @Override
    @Transactional
    public String updateRecordsDocCreateUsl(DocCreateUslEntity docCreateUslEntity) {
        return docCreateUslDAO.updateRecordsDocCreateUsl(docCreateUslEntity);
    }

    @Override
    @Transactional
    public List<DocPlanEntity> getAllRecordsDocPlan() {
        return docPlanDAO.getAllRecordsDocPlan();
    }

    @Override
    @Transactional
    public String addRecordsDocPlan(DocPlanEntity docPlanEntity) {
        return docPlanDAO.addRecordsDocPlan(docPlanEntity);
    }

    @Override
    @Transactional
    public String deleteRecordDocPlan(DocPlanEntity docPlanEntity) {
        return docPlanDAO.deleteRecordDocPlan(docPlanEntity);
    }

    @Override
    @Transactional
    public DocPlanEntity findByIdDocPlan(int id) {
        return docPlanDAO.findByIdDocPlan(id);
    }

    @Override
    @Transactional
    public String updateRecordsDocPlan(DocPlanEntity docPlanEntity) {
        return docPlanDAO.updateRecordsDocPlan(docPlanEntity);
    }

    @Override
    @Transactional
    public List<DogovoraEntity> getAllRecordsDogovora() {
        return dogovoraDAO.getAllRecordsDogovora();
    }

    @Override
    @Transactional
    public String addRecordsDogovora(DogovoraEntity dogovoraEntity) {
        return dogovoraDAO.addRecordsDogovora(dogovoraEntity);
    }

    @Override
    @Transactional
    public String deleteRecordDogovora(DogovoraEntity dogovoraEntity) {
        return dogovoraDAO.deleteRecordDogovora(dogovoraEntity);
    }

    @Override
    @Transactional
    public DogovoraEntity findByIdDogovora(int id) {
        return dogovoraDAO.findByIdDogovora(id);
    }

    @Override
    @Transactional
    public String updateRecordsDogovora(DogovoraEntity dogovoraEntity) {
        return dogovoraDAO.updateRecordsDogovora(dogovoraEntity);
    }

    @Override
    @Transactional
    public List<FilialyEntity> getAllRecordsFilialy() {
        return filialyDAO.getAllRecordsFilialy();
    }

    @Override
    @Transactional
    public String addRecordsFilialy(FilialyEntity filialyEntity) {
        return filialyDAO.addRecordsFilialy(filialyEntity);
    }

    @Override
    @Transactional
    public String deleteRecordFilialy(FilialyEntity filialyEntity) {
        return filialyDAO.deleteRecordFilialy(filialyEntity);
    }

    @Override
    @Transactional
    public FilialyEntity findByIdFilialy(int id) {
        return filialyDAO.findByIdFilialy(id);
    }

    @Override
    @Transactional
    public String updateRecordsFilialy(FilialyEntity filialyEntity) {
        return filialyDAO.updateRecordsFilialy(filialyEntity);
    }

    @Override
    @Transactional
    public List<KontragentEntity> getAllRecordsKontragenty() {
        return kontragentyDAO.getAllRecordsKontragenty();
    }

    @Override
    @Transactional
    public String addRecordsKontragenty(KontragentEntity kontragentEntity) {
        return kontragentyDAO.addRecordsKontragenty(kontragentEntity);
    }

    @Override
    @Transactional
    public String deleteRecordKontragenty(KontragentEntity kontragentEntity) {
        return kontragentyDAO.deleteRecordKontragenty(kontragentEntity);
    }

    @Override
    @Transactional
    public KontragentEntity findByIdKontragenty(int id) {
        return kontragentyDAO.findByIdKontragenty(id);
    }

    @Override
    @Transactional
    public String updateRecordsKontragenty(KontragentEntity kontragentEntity) {
        return kontragentyDAO.updateRecordsKontragenty(kontragentEntity);
    }

   /* @Override
    @Transactional
    public List<PlanbymonthesEntity> getAllRecordsPlanByMonth() {
        return planByMonthDAO.getAllRecordsPlanByMonth();
    }

    @Override
    @Transactional
    public String addRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity) {
        return planByMonthDAO.addRecordsPlanByMonth(planbymonthesEntity);
    }

    @Override
    @Transactional
    public String deleteRecordPlanByMonth(PlanbymonthesEntity planbymonthesEntity) {
        return planByMonthDAO.deleteRecordPlanByMonth(planbymonthesEntity);
    }

    @Override
    @Transactional
    public PlanbymonthesEntity findByIdPlanByMonth(int id) {
        return planByMonthDAO.findByIdPlanByMonth(id);
    }

    @Override
    @Transactional
    public String updateRecordsPlanByMonth(PlanbymonthesEntity planbymonthesEntity) {
        return planByMonthDAO.updateRecordsPlanByMonth(planbymonthesEntity);
    }*/

    @Override
    @Transactional
    public List<UsersEntity> getAllRecordsUserEntity() {
        return userDAO.getAllRecordsUserEntity();
    }

    @Override
    @Transactional
    public void addRecordsUsers(UsersEntity usersEntity) {
        userDAO.addRecordsUsers(usersEntity);
    }

    @Override
    @Transactional
    public void deleteRecordUsers(UsersEntity usersEntity) {
       userDAO.deleteRecordUsers(usersEntity);
    }

    @Override
    @Transactional
    public UsersEntity findByIdUser(int id) {
        return userDAO.findByIdUser(id);
    }

    @Override
    @Transactional
    public String updateRecordsUsers(UsersEntity usersEntity) {
        return userDAO.updateRecordsUsers(usersEntity);
    }

    @Override
    @Transactional
    public List<UslugiEntity> getAllRecordsUslugi() {
        return uslugiDAO.getAllRecordsUslugi();
    }

    @Override
    @Transactional
    public String addRecordsUslugi(UslugiEntity uslugiEntity) {
        return uslugiDAO.addRecordsUslugi(uslugiEntity);
    }

    @Override
    @Transactional
    public String deleteRecordUslugi(UslugiEntity uslugiEntity) {
        return uslugiDAO.deleteRecordUslugi(uslugiEntity);
    }

    @Override
    @Transactional
    public UslugiEntity findByIdUslugi(int id) {
        return uslugiDAO.findByIdUslugi(id);
    }

    @Override
    @Transactional
    public String updateRecordsUslugi(UslugiEntity uslugiEntity) {
        return uslugiDAO.updateRecordsUslugi(uslugiEntity);
    }
}