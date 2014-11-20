package org.springframework.model;

import javax.persistence.*;
import javax.print.Doc;

/**
 * Created by Естай on 18.11.2014.
 */
@Entity
@Table(name = "planbymonthes", schema = "", catalog = "kazgidro")
public class PlanbymonthesEntity {
    private int id;
    private String monthName;
    private int kolvoDogovorov;



    // relationship with docPlanEntity
    private DocPlanEntity docPlanEntity;


    @ManyToOne
    @JoinColumn(name = "docPlanID")
    public DocPlanEntity getDocPlanEntity(){
        return this.docPlanEntity;
    }
    public void setDocPlanEntity(DocPlanEntity docPlanEntity){
        this.docPlanEntity = docPlanEntity;
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
    @Column(name = "monthName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Basic
    @Column(name = "kolvoDogovorov", nullable = true, insertable = true, updatable = true, length = 45)
    public int getKolvoDogovorov() {
        return kolvoDogovorov;
    }

    public void setKolvoDogovorov(int kolvoDogovorov) {
        this.kolvoDogovorov = kolvoDogovorov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanbymonthesEntity that = (PlanbymonthesEntity) o;

        if (id != that.id) return false;
        if (monthName != null ? !monthName.equals(that.monthName) : that.monthName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (monthName != null ? monthName.hashCode() : 0);
        return result;
    }
}
