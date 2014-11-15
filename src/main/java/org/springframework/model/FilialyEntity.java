package org.springframework.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 15.11.2014.
 */
@Entity
@Table(name = "filialy", schema = "", catalog = "kazgidro")
public class FilialyEntity {
    private int filialid;
    private String naimenovanie;
    private Collection<DocCreateUslEntity> docCreateUslsByFilialid;

    @Id
    @Column(name = "filialid", nullable = false, insertable = true, updatable = true)
    public int getFilialid() {
        return filialid;
    }

    public void setFilialid(int filialid) {
        this.filialid = filialid;
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

        FilialyEntity that = (FilialyEntity) o;

        if (filialid != that.filialid) return false;
        if (naimenovanie != null ? !naimenovanie.equals(that.naimenovanie) : that.naimenovanie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filialid;
        result = 31 * result + (naimenovanie != null ? naimenovanie.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "filialyByFilialId")
    public Collection<DocCreateUslEntity> getDocCreateUslsByFilialid() {
        return docCreateUslsByFilialid;
    }

    public void setDocCreateUslsByFilialid(Collection<DocCreateUslEntity> docCreateUslsByFilialid) {
        this.docCreateUslsByFilialid = docCreateUslsByFilialid;
    }
}
