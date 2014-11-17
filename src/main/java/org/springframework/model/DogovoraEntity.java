package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Естай on 11.11.2014.
 */
@Entity
@Table(name = "dogovora", schema = "", catalog = "kazgidro")
public class DogovoraEntity {
    private int dogovorid;
    private Date startDate;
    private Date endDate;
    private double summa;

    //relationship with doc create uslugi
    private Set<DocCreateUslEntity> docUslugi = new HashSet<DocCreateUslEntity>();

    @OneToMany(mappedBy = "dogovoraEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<DocCreateUslEntity> getDocUslugi(){
        return this.docUslugi;
    }
    public void setDocUslugi(Set<DocCreateUslEntity> docUslugiSet){
        this.docUslugi = docUslugiSet;
    }

    public void addDocUslugi(DocCreateUslEntity docCreateUslEntity){
        docCreateUslEntity.setDogovoraEntity(this);
        getDocUslugi().add(docCreateUslEntity);
    }

    public void removeDocUslugi(DocCreateUslEntity docCreateUslEntity){
        getDocUslugi().remove(docCreateUslEntity);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dogovorid", nullable = false, insertable = true, updatable = true)
    public int getDogovorid() {
        return dogovorid;
    }

    public void setDogovorid(int dogovorid) {
        this.dogovorid = dogovorid;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date", nullable = false, insertable = true, updatable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false, insertable = true, updatable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "Summa", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DogovoraEntity that = (DogovoraEntity) o;

        if (dogovorid != that.dogovorid) return false;
        if (Double.compare(that.summa, summa) != 0) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dogovorid;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        temp = Double.doubleToLongBits(summa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
