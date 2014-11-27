package org.springframework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Администратор on 21.11.2014.
 */
@Entity
@Table(name = "doc_plan", schema = "", catalog = "kazgidro")
public class DocPlanEntity {
    private int id;
    private Timestamp date;
    private String jan;
    private String feb;
    private String mar;
    private String apr;
    private String may;
    private String june;
    private String july;
    private String auv;
    private String sep;
    private String oct;
    private String nov;
    private String dec;
    private int year;





    private UsersEntity usersEntity;

    @ManyToOne
    @JoinColumn(name = "avtor")
    public UsersEntity getUsersEntity(){
        return this.usersEntity;
    }
    public void setUsersEntity(UsersEntity usersEntity){
        this.usersEntity = usersEntity;
    }





    //relationship with filialyEntity
    private FilialyEntity filialyEntity;

    @ManyToOne
    @JoinColumn(name = "filialID")
    public FilialyEntity getFilialyEntity(){
        return this.filialyEntity;
    }
    public void setFilialyEntity(FilialyEntity filialyEntity){
        this.filialyEntity = filialyEntity;
    }



    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = true, insertable = true, updatable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Jan", nullable = true, insertable = true, updatable = true, length = 45)
    public String getJan() {
        return jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    @Basic
    @Column(name = "Feb", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFeb() {
        return feb;
    }

    public void setFeb(String feb) {
        this.feb = feb;
    }

    @Basic
    @Column(name = "Mar", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    @Basic
    @Column(name = "Apr", nullable = true, insertable = true, updatable = true, length = 45)
    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    @Basic
    @Column(name = "May", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    @Basic
    @Column(name = "June", nullable = true, insertable = true, updatable = true, length = 45)
    public String getJune() {
        return june;
    }

    public void setJune(String june) {
        this.june = june;
    }

    @Basic
    @Column(name = "July", nullable = true, insertable = true, updatable = true, length = 45)
    public String getJuly() {
        return july;
    }

    public void setJuly(String july) {
        this.july = july;
    }

    @Basic
    @Column(name = "Auv", nullable = true, insertable = true, updatable = true, length = 45)
    public String getAuv() {
        return auv;
    }

    public void setAuv(String auv) {
        this.auv = auv;
    }

    @Basic
    @Column(name = "Sep", nullable = true, insertable = true, updatable = true, length = 45)
    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    @Basic
    @Column(name = "Oct", nullable = true, insertable = true, updatable = true, length = 45)
    public String getOct() {
        return oct;
    }

    public void setOct(String oct) {
        this.oct = oct;
    }

    @Basic
    @Column(name = "Nov", nullable = true, insertable = true, updatable = true, length = 45)
    public String getNov() {
        return nov;
    }

    public void setNov(String nov) {
        this.nov = nov;
    }

    @Basic
    @Column(name = "Dec", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    @Basic
    @Column(name = "year", nullable = true, insertable = true, updatable = true)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocPlanEntity that = (DocPlanEntity) o;




        if (id != that.id) return false;
        if (year != that.year) return false;
        if (apr != null ? !apr.equals(that.apr) : that.apr != null) return false;
        if (auv != null ? !auv.equals(that.auv) : that.auv != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (dec != null ? !dec.equals(that.dec) : that.dec != null) return false;
        if (feb != null ? !feb.equals(that.feb) : that.feb != null) return false;
        if (jan != null ? !jan.equals(that.jan) : that.jan != null) return false;
        if (july != null ? !july.equals(that.july) : that.july != null) return false;
        if (june != null ? !june.equals(that.june) : that.june != null) return false;
        if (mar != null ? !mar.equals(that.mar) : that.mar != null) return false;
        if (may != null ? !may.equals(that.may) : that.may != null) return false;
        if (nov != null ? !nov.equals(that.nov) : that.nov != null) return false;
        if (oct != null ? !oct.equals(that.oct) : that.oct != null) return false;
        if (sep != null ? !sep.equals(that.sep) : that.sep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (jan != null ? jan.hashCode() : 0);
        result = 31 * result + (feb != null ? feb.hashCode() : 0);
        result = 31 * result + (mar != null ? mar.hashCode() : 0);
        result = 31 * result + (apr != null ? apr.hashCode() : 0);
        result = 31 * result + (may != null ? may.hashCode() : 0);
        result = 31 * result + (june != null ? june.hashCode() : 0);
        result = 31 * result + (july != null ? july.hashCode() : 0);
        result = 31 * result + (auv != null ? auv.hashCode() : 0);
        result = 31 * result + (sep != null ? sep.hashCode() : 0);
        result = 31 * result + (oct != null ? oct.hashCode() : 0);
        result = 31 * result + (nov != null ? nov.hashCode() : 0);
        result = 31 * result + (dec != null ? dec.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
