package org.springframework.dao;

import org.hibernate.metamodel.domain.Entity;
import org.springframework.model.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Администратор on 10.11.2014.
 */

public interface UserDAO {

    public List<UsersEntity> getAllRecordsUserEntity();

    public void addRecordsUsers(UsersEntity usersEntity);

    public void deleteRecordUsers(UsersEntity usersEntity);

    public UsersEntity findByIdUser(int id);

    public String updateRecordsUsers(UsersEntity usersEntity);



}
