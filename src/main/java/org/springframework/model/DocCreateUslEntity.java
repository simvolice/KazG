package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Естай on 17.11.2014.
 */
@Entity
@Table(name = "doc_create_usl", schema = "", catalog = "kazgidro")
public class DocCreateUslEntity {
    private int docCreateUslId;
    private Timestamp date;
    private Double stoimost;


    // relationsip with kontragent entit

    private KontragentEntity kontragentEntity;

    @ManyToOne
    @JoinColumn(name = "kontragentyid")
    public KontragentEntity getKontragentEntity() {

        return this.kontragentEntity;
    }
    public void setKontragentEntity(KontragentEntity kontragentEntity){
        this.kontragentEntity = kontragentEntity;
    }

    //relationship with filialyEntity
    private FilialyEntity filialyEntity;

    @ManyToOne
    @JoinColumn(name = "filialid")
    public FilialyEntity getFilialyEntity(){
        return this.filialyEntity;
    }
    public void setFilialyEntity(FilialyEntity filialyEntity){
        this.filialyEntity = filialyEntity;
    }




    //relationship with dogovoraEntity
    private DogovoraEntity dogovoraEntity;

    @ManyToOne
    @JoinColumn(name = "dogovorid")
    public DogovoraEntity getDogovoraEntity(){
        return this.dogovoraEntity;
    }
    public void setDogovoraEntity(DogovoraEntity dogovoraEntity){
        this.dogovoraEntity = dogovoraEntity;
    }


    //relationship with uslugi entity
    private UslugiEntity uslugiEntity;

    @ManyToOne
    @JoinColumn(name = "uslugaid")
    public UslugiEntity getUslugiEntity(){
        return this.uslugiEntity;
    }
    public void setUslugiEntity(UslugiEntity uslugiEntity){
        this.uslugiEntity = uslugiEntity;
    }



    //relationship with userEntity
    private UsersEntity usersEntity;

    @ManyToOne
    @JoinColumn(name = "userid")
    public UsersEntity getUsersEntity(){
        return this.usersEntity;
    }
    public void setUsersEntity(UsersEntity usersEntity){
        this.usersEntity = usersEntity;
    }







    @Id
    @Column(name = "docCreateUslID", nullable = false, insertable = true, updatable = true)
    public int getDocCreateUslId() {
        return docCreateUslId;
    }

    public void setDocCreateUslId(int docCreateUslId) {
        this.docCreateUslId = docCreateUslId;
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
    @Column(name = "stoimost", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getStoimost() {
        return stoimost;
    }

    public void setStoimost(Double stoimost) {
        this.stoimost = stoimost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocCreateUslEntity that = (DocCreateUslEntity) o;

        if (docCreateUslId != that.docCreateUslId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (stoimost != null ? !stoimost.equals(that.stoimost) : that.stoimost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docCreateUslId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (stoimost != null ? stoimost.hashCode() : 0);
        return result;
    }
}
