package org.springframework.model;

import javax.persistence.*;
import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Естай on 17.11.2014.
 */
@Entity
@Table(name = "filialy", schema = "", catalog = "kazgidro")
public class FilialyEntity {
    private int filialid;
    private String naimenovanie;


    // relationship with DOC plan entity
    private Set<DocPlanEntity> docPlanEntities = new HashSet<DocPlanEntity>();


    @OneToMany(mappedBy = "filialyEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<DocPlanEntity> getDocPlanEntities(){
        return this.docPlanEntities;
    }
    public void setDocPlanEntities(Set<DocPlanEntity> docPlanEntities){
        this.docPlanEntities= docPlanEntities;
    }

    public void addDocPlan(DocPlanEntity docPlanEntity){
        docPlanEntity.setFilialyEntity(this);
        getDocPlanEntities().add(docPlanEntity);
    }

    public void removeDocPlan(DocPlanEntity docPlanEntity){
        getDocPlanEntities().remove(docPlanEntity);
    }



    //relationship with docCreateEntity
    private Set<DocCreateUslEntity> docUslugi = new HashSet<DocCreateUslEntity>();

    @OneToMany(mappedBy = "filialyEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<DocCreateUslEntity> getDocUslugi(){
        return this.docUslugi;
    }
    public void setDocUslugi(Set<DocCreateUslEntity> docUslugiSet){
        this.docUslugi = docUslugiSet;
    }


    public void addDocUslugi(DocCreateUslEntity docCreateUslEntity){
        docCreateUslEntity.setFilialyEntity(this);
        getDocUslugi().add(docCreateUslEntity);
    }

    public void removeDocUslugi(DocCreateUslEntity docCreateUslEntity){
        getDocUslugi().remove(docCreateUslEntity);
    }




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
}
