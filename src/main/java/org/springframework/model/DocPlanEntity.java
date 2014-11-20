package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Естай on 18.11.2014.
 */
@Entity
@Table(name = "doc_plan", schema = "", catalog = "kazgidro")
public class DocPlanEntity {
    private int id;
    private Timestamp date;
    private int year;




    //relationship with User entity


    private UsersEntity usersEntity;

    @ManyToOne
    @JoinColumn(name = "avtor")
    public UsersEntity getUsersEntity(){
        return this.usersEntity;
    }
    public void setUsersEntity(UsersEntity usersEntity){
        this.usersEntity = usersEntity;
    }





    //relationship with filialyEntity
    private FilialyEntity filialyEntity;

    @ManyToOne
    @JoinColumn(name = "filialID")
    public FilialyEntity getFilialyEntity(){
        return this.filialyEntity;
    }
    public void setFilialyEntity(FilialyEntity filialyEntity){
        this.filialyEntity = filialyEntity;
    }





    //relationship with Plan by month
    private Set<PlanbymonthesEntity> planByMonth = new HashSet<PlanbymonthesEntity>();



    @OneToMany(mappedBy = "docPlanEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<PlanbymonthesEntity> getPlanByMonth(){
        return this.planByMonth;
    }
    public void setPlanByMonth(Set<PlanbymonthesEntity> planByMonth){
        this.planByMonth = planByMonth;
    }

    public void addPlanByMonth(PlanbymonthesEntity planbymonthesEntity){
        planbymonthesEntity.setDocPlanEntity(this);
        getPlanByMonth().add(planbymonthesEntity);
    }

    public void removePlanByMonth(PlanbymonthesEntity planbymonthesEntity){
        getPlanByMonth().remove(planbymonthesEntity);
    }






    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }



    @Column(name = "year", nullable = false, insertable = true, updatable = true)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
