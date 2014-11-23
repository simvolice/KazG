package org.springframework.model;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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


    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Column(name = "userpassword", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }


    @Column(name = "userrole", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }


    @Column(name = "userfirstname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }


    @Column(name = "userlastname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }


    @Column(name = "useremail", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }




}
