package org.springframework.dao;

import org.springframework.model.UsersEntity;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

/**
 * Created by user on 15.11.2014.
 */
public interface UserDAO {




    @Secured("ROLE_ADMIN")
    public String AddUser (UsersEntity usersEntity);

    public String DeleteUser (Integer usrId);


    public List<UsersEntity> GetAllUsers();



}
