package org.springframework.dao;

import org.springframework.model.UsersEntity;

/**
 * Created by user on 15.11.2014.
 */
public interface UserDAO {


public String UserAunth(String usrName, String usrPass);


    public String AddUser (UsersEntity usersEntity);

    public String DeleteUser (Integer usrId);



}
