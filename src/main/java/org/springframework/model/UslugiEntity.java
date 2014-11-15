package org.springframework.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 15.11.2014.
 */
@Entity
@Table(name = "uslugi", schema = "", catalog = "kazgidro")
public class UslugiEntity {
    private int uslugiid;
    private String naimenovanie;
    private Collection<DocCreateUslEntity> docCreateUslsByUslugiid;

    @Id
    @Column(name = "uslugiid", nullable = false, insertable = true, updatable = true)
    public int getUslugiid() {
        return uslugiid;
    }

    public void setUslugiid(int uslugiid) {
        this.uslugiid = uslugiid;
    }

    @Basic
    @Column(name = "naimenovanie", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNaimenovanie() {
        return naimenovanie;
    }

    public void setNaimenovanie(String naimenovanie) {
        this.naimenovanie = naimenovanie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UslugiEntity that = (UslugiEntity) o;

        if (uslugiid != that.uslugiid) return false;
        if (naimenovanie != null ? !naimenovanie.equals(that.naimenovanie) : that.naimenovanie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uslugiid;
        result = 31 * result + (naimenovanie != null ? naimenovanie.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "uslugiByUslugaId")
    public Collection<DocCreateUslEntity> getDocCreateUslsByUslugiid() {
        return docCreateUslsByUslugiid;
    }

    public void setDocCreateUslsByUslugiid(Collection<DocCreateUslEntity> docCreateUslsByUslugiid) {
        this.docCreateUslsByUslugiid = docCreateUslsByUslugiid;
    }
}
