package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by user on 15.11.2014.
 */
@Entity
@Table(name = "doc_create_usl", schema = "", catalog = "kazgidro")
public class DocCreateUslEntity {
    private int docCreateUslId;
    private Timestamp date;
    private Double stoimost;
    private DogovoraEntity dogovoraByDogovorId;
    private FilialyEntity filialyByFilialId;
    private KontragentEntity kontragentByKontragentyId;
    private UsersEntity usersByUserId;
    private UslugiEntity uslugiByUslugaId;

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

    @ManyToOne
    @JoinColumn(name = "dogovorID", referencedColumnName = "dogovorid", nullable = false)
    public DogovoraEntity getDogovoraByDogovorId() {
        return dogovoraByDogovorId;
    }

    public void setDogovoraByDogovorId(DogovoraEntity dogovoraByDogovorId) {
        this.dogovoraByDogovorId = dogovoraByDogovorId;
    }

    @ManyToOne
    @JoinColumn(name = "filialID", referencedColumnName = "filialid", nullable = false)
    public FilialyEntity getFilialyByFilialId() {
        return filialyByFilialId;
    }

    public void setFilialyByFilialId(FilialyEntity filialyByFilialId) {
        this.filialyByFilialId = filialyByFilialId;
    }

    @ManyToOne
    @JoinColumn(name = "kontragentyID", referencedColumnName = "kontragentid", nullable = false)
    public KontragentEntity getKontragentByKontragentyId() {
        return kontragentByKontragentyId;
    }

    public void setKontragentByKontragentyId(KontragentEntity kontragentByKontragentyId) {
        this.kontragentByKontragentyId = kontragentByKontragentyId;
    }

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userid", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "uslugaID", referencedColumnName = "uslugiid", nullable = false)
    public UslugiEntity getUslugiByUslugaId() {
        return uslugiByUslugaId;
    }

    public void setUslugiByUslugaId(UslugiEntity uslugiByUslugaId) {
        this.uslugiByUslugaId = uslugiByUslugaId;
    }
}
