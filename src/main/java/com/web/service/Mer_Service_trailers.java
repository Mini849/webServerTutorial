package com.web.service;


import com.web.model.MerM_Data;
import com.web.model.Mer_Trailers;
import com.web.repository.MerRepo_trailers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mer_Service_trailers {

    @Autowired
    MerRepo_trailers merRepo_trailers;

    public List<String> getAll() {
        List<String> mer_trailers = new ArrayList<>();
        merRepo_trailers.findAll().forEach(Mer_Trailers -> mer_trailers.add(Mer_Trailers.getTrailers()));
        return mer_trailers;
    }

    public Mer_Trailers getByID(long id) {
        return merRepo_trailers.findById(id).get();
    }

    public void saveOrUpdate(Mer_Trailers trailers) {
        merRepo_trailers.save(trailers);
    }

    public void delete(long id) {
        merRepo_trailers.deleteById(id);
    }

    public void deleteAll() {
        merRepo_trailers.deleteAll();
    }

}
