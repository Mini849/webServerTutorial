package com.example.webServerTutorialPage.repository;

import com.example.webServerTutorialPage.model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {



}
