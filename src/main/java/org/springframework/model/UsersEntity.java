package org.springframework.model;

import org.hibernate.internal.util.ValueHolder;
import org.hibernate.metamodel.domain.*;
import org.springframework.dao.UserDAO;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.print.Doc;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.GenerationType;

/**
 * Created by Естай on 11.11.2014.
 */
@Entity
@Table(name = "users", schema = "", catalog = "kazgidro")
public class UsersEntity{
    private int userid;
    private String username;
    private String userpassword;
    private String userrole;
    private String userfirstname;
    private String userlastname;
    private String useremail;


    //relationship with doc create uslugi
    private Set<DocCreateUslEntity> docCreateUslEntitySet = new HashSet<DocCreateUslEntity>();


    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<DocCreateUslEntity> getDocCreateUslEntitySet(){
        return this.docCreateUslEntitySet;
    }
    public void setDocCreateUslEntitySet(Set<DocCreateUslEntity> docCreateUslEntitySet){
        this.docCreateUslEntitySet = docCreateUslEntitySet;
    }

    public void addDocUslugi(DocCreateUslEntity docCreateUslEntity){
        docCreateUslEntity.setUsersEntity(this);
        getDocCreateUslEntitySet().add(docCreateUslEntity);
    }
    public void removeDocUslugi(DocCreateUslEntity docCreateUslEntity){
        getDocCreateUslEntitySet().remove(docCreateUslEntity);
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false, insertable = true, updatable = true)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpassword", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Basic
    @Column(name = "userrole", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Basic
    @Column(name = "userfirstname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    @Basic
    @Column(name = "userlastname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    @Basic
    @Column(name = "useremail", nullable = false, insertable = true, updatable = true, length = 45)
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }




}
