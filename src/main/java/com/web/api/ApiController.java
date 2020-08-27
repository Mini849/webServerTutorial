package com.web.api;

import com.web.model.Feedback;
import com.web.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    BuildProperties buildProperties;

    @GetMapping("/feedback/{id}")
    private Feedback getFeedback(long id) {
        return feedbackService.getFeedbackByID(id);
    }

    @DeleteMapping("/feedback/{id}")
    private void deleteFeedback(long id) {
        feedbackService.delete(id);
    }

    @GetMapping("/db")
    private List<Feedback> getAllFeedbacks() {

        System.out.println("Build version:" + buildProperties.getVersion());

        return feedbackService.getAllFeedbacks();
    }

    @PostMapping("/saveFeedback")
    private long saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveOrUpdate(feedback);
        return feedback.getId();
    }

}
