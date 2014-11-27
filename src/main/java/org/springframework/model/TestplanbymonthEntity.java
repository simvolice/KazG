package org.springframework.model;

import javax.persistence.*;

/**
 * Created by user on 27.11.2014.
 */
@Entity
@Table(name = "testplanbymonth", schema = "", catalog = "kazgidro")
public class TestplanbymonthEntity {
    private int id;
    private String monthName;
    private String kolvoUslug;

    private DocPlanEntity docPlanEntity;
    @ManyToOne
    @JoinColumn(name = "docplanid")
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
    @Column(name = "monthName", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Basic
    @Column(name = "kolvoUslug", nullable = true, insertable = true, updatable = true, length = 45)
    public String getKolvoUslug() {
        return kolvoUslug;
    }

    public void setKolvoUslug(String kolvoUslug) {
        this.kolvoUslug = kolvoUslug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestplanbymonthEntity that = (TestplanbymonthEntity) o;

        if (id != that.id) return false;
        if (kolvoUslug != null ? !kolvoUslug.equals(that.kolvoUslug) : that.kolvoUslug != null) return false;
        if (monthName != null ? !monthName.equals(that.monthName) : that.monthName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (monthName != null ? monthName.hashCode() : 0);
        result = 31 * result + (kolvoUslug != null ? kolvoUslug.hashCode() : 0);
        return result;
    }
}
