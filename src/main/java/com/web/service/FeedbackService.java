package com.web.service;

import java.util.ArrayList;
import java.util.List;

import com.web.model.Feedback;
import com.web.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<Feedback>();
        feedbackRepository.findAll().forEach(feedback -> feedbacks.add(feedback));
        return feedbacks;
    }

    public Feedback getFeedbackByID(long id) {
        return feedbackRepository.findById(id).get();
    }

    public void saveOrUpdate(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public void delete(long id) {
        feedbackRepository.deleteById(id);
    }

}
