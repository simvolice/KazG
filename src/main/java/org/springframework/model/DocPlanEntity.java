package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by user on 15.11.2014.
 */
@Entity
@Table(name = "doc_plan", schema = "", catalog = "kazgidro")
public class DocPlanEntity {
    private int id;
    private Timestamp date;
    private String nomer;
    private String avtor;

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

    @Basic
    @Column(name = "nomer", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    @Basic
    @Column(name = "avtor", nullable = false, insertable = true, updatable = true, length = 45)
    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocPlanEntity that = (DocPlanEntity) o;

        if (id != that.id) return false;
        if (avtor != null ? !avtor.equals(that.avtor) : that.avtor != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (nomer != null ? !nomer.equals(that.nomer) : that.nomer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (nomer != null ? nomer.hashCode() : 0);
        result = 31 * result + (avtor != null ? avtor.hashCode() : 0);
        return result;
    }
}
