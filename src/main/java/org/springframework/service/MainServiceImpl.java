package org.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DocCreateUslDAO;
import org.springframework.dao.DogovoraDAO;
import org.springframework.model.DocCreateUslEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 19.11.2014.
 */
@Service
public class MainServiceImpl implements MainService {


    private DocCreateUslDAO docCreateUslDAO;
    private DogovoraDAO dogovoraDAO;

    @Autowired
    public MainServiceImpl(DocCreateUslDAO docCreateUslDAO, DogovoraDAO dogovoraDAO) {

        this.docCreateUslDAO = docCreateUslDAO;
        this.dogovoraDAO = dogovoraDAO;

    }



    @Override
    public List<DocCreateUslEntity> getAllRecordsDocCreateUsl() {
        return null;
    }
}
