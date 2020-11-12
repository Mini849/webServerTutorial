package com.web.service;


import com.web.model.MerM_Data;
import com.web.repository.MerRepo_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mer_Service_data {

    @Autowired
    MerRepo_data merRepositary_data;

    public List<String> getAllMerData() {
        List<String> mer_m_data = new ArrayList<String>();
        merRepositary_data.findAll().forEach(MerM_Data -> mer_m_data.add(MerM_Data.getData()));
        return mer_m_data;
    }

    public MerM_Data getData_MeeraneByID(long id) {
        return merRepositary_data.findById(id).get();
    }

    public void saveOrUpdate(MerM_Data dataMeerane) {
        merRepositary_data.save(dataMeerane);
    }

    public void delete(long id) {
        merRepositary_data.deleteById(id);
    }

    public void deleteAll() {
        merRepositary_data.deleteAll();
    }

}
