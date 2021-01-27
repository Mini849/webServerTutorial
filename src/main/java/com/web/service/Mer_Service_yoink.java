package com.web.service;



import com.web.model.Mer_Yoink;
import com.web.repository.MerRepo_yoink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mer_Service_yoink {

    @Autowired
    MerRepo_yoink merRepo_yoink;

    public List<String> getAll() {
        List<String > mer_yoinks = new ArrayList<>();
        merRepo_yoink.findAll().forEach(Mer_Yoink -> mer_yoinks.add(Mer_Yoink.getYoink()));
        return mer_yoinks;
    }

    public Mer_Yoink getByID(long id) {
        return merRepo_yoink.findById(id).get();
    }

    public void saveOrUpdate(Mer_Yoink yoink) {
        merRepo_yoink.save(yoink);
    }

    public void delete(long id) {
        merRepo_yoink.deleteById(id);
    }

    public void deleteAll() {
        merRepo_yoink.deleteAll();
    }

}
