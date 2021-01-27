package com.web.repository;

import com.web.model.Mer_Trailers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerRepo_trailers extends CrudRepository<Mer_Trailers, Long> {
}
