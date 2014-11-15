package org.springframework.dao;

import org.springframework.model.UsersEntity;

/**
 * Created by user on 15.11.2014.
 */
public interface Dao {


//public String UserAunth(String usrName, String usrPass);


    public String AddUser ();

    public String DeleteUser (String usrName);



}
