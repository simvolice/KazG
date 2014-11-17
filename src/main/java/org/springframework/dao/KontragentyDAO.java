package org.springframework.dao;

import org.springframework.model.DogovoraEntity;
import org.springframework.model.KontragentEntity;

import java.util.List;

/**
 * Created by Естай on 17.11.2014.
 */
public interface KontragentyDAO {


    public List<KontragentEntity> getAllRecordsKontragenty();

    public String addRecordsKontragenty(KontragentEntity kontragentEntity);

    public String deleteRecordKontragenty(KontragentEntity kontragentEntity);

    public KontragentEntity findByIdKontragenty(int id);

    public String updateRecordsKontragenty(KontragentEntity kontragentEntity);
}
