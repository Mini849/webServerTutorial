package com.example.webServerTutorialPage.api;

import com.example.webServerTutorialPage.model.Feedback;
import com.example.webServerTutorialPage.service.FeedbackService;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;


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
//        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./data/employees", "sa", null).load();
//
//        // Start the migration
//        flyway.migrate();
        return feedbackService.getAllFeedbacks();

    }

    @PostMapping("/saveFeedback")
    private long saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveOrUpdate(feedback);
        return feedback.getId();
    }

}
