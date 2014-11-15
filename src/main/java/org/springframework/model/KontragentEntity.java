package org.springframework.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 15.11.2014.
 */
@Entity
@Table(name = "kontragent", schema = "", catalog = "kazgidro")
public class KontragentEntity {
    private int kontragentid;
    private String naimenovanie;
    private String bin;
    private String iin;
    private Collection<DocCreateUslEntity> docCreateUslsByKontragentid;

    @Id
    @Column(name = "kontragentid", nullable = false, insertable = true, updatable = true)
    public int getKontragentid() {
        return kontragentid;
    }

    public void setKontragentid(int kontragentid) {
        this.kontragentid = kontragentid;
    }

    @Basic
    @Column(name = "naimenovanie", nullable = false, insertable = true, updatable = true, length = 45)
    public String getNaimenovanie() {
        return naimenovanie;
    }

    public void setNaimenovanie(String naimenovanie) {
        this.naimenovanie = naimenovanie;
    }

    @Basic
    @Column(name = "BIN", nullable = false, insertable = true, updatable = true, length = 45)
    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    @Basic
    @Column(name = "IIN", nullable = false, insertable = true, updatable = true, length = 45)
    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KontragentEntity that = (KontragentEntity) o;

        if (kontragentid != that.kontragentid) return false;
        if (bin != null ? !bin.equals(that.bin) : that.bin != null) return false;
        if (iin != null ? !iin.equals(that.iin) : that.iin != null) return false;
        if (naimenovanie != null ? !naimenovanie.equals(that.naimenovanie) : that.naimenovanie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kontragentid;
        result = 31 * result + (naimenovanie != null ? naimenovanie.hashCode() : 0);
        result = 31 * result + (bin != null ? bin.hashCode() : 0);
        result = 31 * result + (iin != null ? iin.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kontragentByKontragentyId")
    public Collection<DocCreateUslEntity> getDocCreateUslsByKontragentid() {
        return docCreateUslsByKontragentid;
    }

    public void setDocCreateUslsByKontragentid(Collection<DocCreateUslEntity> docCreateUslsByKontragentid) {
        this.docCreateUslsByKontragentid = docCreateUslsByKontragentid;
    }
}
