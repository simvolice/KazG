package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by user on 15.11.2014.
 */
@Entity
@Table(name = "dogovora", schema = "", catalog = "kazgidro")
public class DogovoraEntity {
    private int dogovorid;
    private Timestamp startDate;
    private Timestamp endDate;
    private double summa;
    private Collection<DocCreateUslEntity> docCreateUslsByDogovorid;

    @Id
    @Column(name = "dogovorid", nullable = false, insertable = true, updatable = true)
    public int getDogovorid() {
        return dogovorid;
    }

    public void setDogovorid(int dogovorid) {
        this.dogovorid = dogovorid;
    }

    @Basic
    @Column(name = "start_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
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

    @OneToMany(mappedBy = "dogovoraByDogovorId")
    public Collection<DocCreateUslEntity> getDocCreateUslsByDogovorid() {
        return docCreateUslsByDogovorid;
    }

    public void setDocCreateUslsByDogovorid(Collection<DocCreateUslEntity> docCreateUslsByDogovorid) {
        this.docCreateUslsByDogovorid = docCreateUslsByDogovorid;
    }
}
