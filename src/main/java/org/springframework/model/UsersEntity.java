package org.springframework.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Естай on 17.11.2014.
 */
@Entity
@Table(name = "users", schema = "", catalog = "kazgidro")
public class UsersEntity {
    private int userid;
    private String username;
    private String userpassword;
    private String userrole;
    private String userfirstname;
    private String userlastname;
    private String useremail;




    // relationship with DOC plan entity
    private Set<DocPlanEntity> docPlanEntities = new HashSet<DocPlanEntity>();


    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<DocPlanEntity> getDocPlanEntities(){
        return this.docPlanEntities;
    }
    public void setDocPlanEntities(Set<DocPlanEntity> docPlanEntities){
        this.docPlanEntities= docPlanEntities;
    }

    public void addDocPlan(DocPlanEntity docPlanEntity){
        docPlanEntity.setUsersEntity(this);
        getDocPlanEntities().add(docPlanEntity);
    }

    public void removeDocPlan(DocPlanEntity docPlanEntity){
        getDocPlanEntities().remove(docPlanEntity);
    }



    // relaship with doc
    private Set<DocCreateUslEntity> docUslugi = new HashSet<DocCreateUslEntity>();

    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public Set<DocCreateUslEntity> getDocUslugi(){
        return this.docUslugi;
    }
    public void setDocUslugi(Set<DocCreateUslEntity> docCreateUslEntitySet){
        this.docUslugi = docCreateUslEntitySet;
    }

    public void addDocUslugi(DocCreateUslEntity docCreateUslEntity){
        docCreateUslEntity.setUsersEntity(this);
        getDocUslugi().add(docCreateUslEntity);
    }
    public void removeDocUslugi(DocCreateUslEntity docCreateUslEntity){
        getDocUslugi().remove(docCreateUslEntity);
    }



    @Id
    @Column(name = "userid", nullable = false, insertable = true, updatable = true)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpassword", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Basic
    @Column(name = "userrole", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Basic
    @Column(name = "userfirstname", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    @Basic
    @Column(name = "userlastname", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    @Basic
    @Column(name = "useremail", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (userid != that.userid) return false;
        if (useremail != null ? !useremail.equals(that.useremail) : that.useremail != null) return false;
        if (userfirstname != null ? !userfirstname.equals(that.userfirstname) : that.userfirstname != null)
            return false;
        if (userlastname != null ? !userlastname.equals(that.userlastname) : that.userlastname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (userpassword != null ? !userpassword.equals(that.userpassword) : that.userpassword != null) return false;
        if (userrole != null ? !userrole.equals(that.userrole) : that.userrole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (userpassword != null ? userpassword.hashCode() : 0);
        result = 31 * result + (userrole != null ? userrole.hashCode() : 0);
        result = 31 * result + (userfirstname != null ? userfirstname.hashCode() : 0);
        result = 31 * result + (userlastname != null ? userlastname.hashCode() : 0);
        result = 31 * result + (useremail != null ? useremail.hashCode() : 0);
        return result;
    }
}
