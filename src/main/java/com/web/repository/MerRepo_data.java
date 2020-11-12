package com.web.repository;


import com.web.model.MerM_Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerRepo_data extends CrudRepository<MerM_Data, Long> {
}
