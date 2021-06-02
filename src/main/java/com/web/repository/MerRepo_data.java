package com.web.repository;


import com.web.model.Mer_Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerRepo_data extends CrudRepository<Mer_Data, Long> {
}
