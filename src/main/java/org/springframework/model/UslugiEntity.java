package org.springframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Естай on 17.11.2014.
 */
@Entity
@Table(name = "uslugi", schema = "", catalog = "kazgidro")
public class UslugiEntity {
    private int uslugiid;
    private String naimenovanie;




    // relaship with doc
    private Set<DocCreateUslEntity> docCreateUslEntitySet = new HashSet<DocCreateUslEntity>();

    @OneToMany(mappedBy = "uslugiEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<DocCreateUslEntity> getDocCreateUslEntitySet(){
        return this.docCreateUslEntitySet;
    }
    public void setDocCreateUslEntitySet(Set<DocCreateUslEntity> docCreateUslEntitySet){
        this.docCreateUslEntitySet = docCreateUslEntitySet;
    }

    public void addDocUslugi(DocCreateUslEntity docCreateUslEntity){
        docCreateUslEntity.setUslugiEntity(this);
        getDocCreateUslEntitySet().add(docCreateUslEntity);
    }
    public void removeDocUslugi(DocCreateUslEntity docCreateUslEntity){
        getDocCreateUslEntitySet().remove(docCreateUslEntity);
    }

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
}
