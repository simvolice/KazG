package org.springframework.dao;

import org.springframework.model.KontragentEntity;
import org.springframework.model.UslugiEntity;

import java.util.List;

/**
 * Created by Естай on 17.11.2014.
 */
public interface UslugiDAO {


    public List<UslugiEntity> getAllRecordsUslugi();

    public String addRecordsUslugi(UslugiEntity uslugiEntity);

    public String deleteRecordUslugi(UslugiEntity uslugiEntity);

    public UslugiEntity findByIdUslugi(int id);

    public String updateRecordsUslugi(UslugiEntity uslugiEntity);

}
