package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Естай on 11.11.2014.
 */
@Entity
@Table(name = "doc_create_usl", schema = "", catalog = "kazgidro")
public class DocCreateUslEntity {
    private int docCreateUslId;
    private Timestamp date;
    private Double stoimost;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


}
