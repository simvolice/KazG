package org.springframework.dao;

import org.springframework.model.UsersEntity;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Администратор on 10.11.2014.
 */
public interface UsersDAO {

    Collection<UsersEntity> findAll() throws DataAccessException;



}
