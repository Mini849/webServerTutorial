package com.web.api;

import com.web.model.Feedback;

import com.web.service.FeedbackService;

import com.web.service.ReworkService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    BuildProperties buildProperties;

    @Autowired
    ReworkService reworkService;


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

    @RequestMapping(
            value = "/Glechau/reworkData",
            method = RequestMethod.POST)
    public void process(@RequestBody List<String> payload)
            throws Exception {

        reworkService.save(payload);
    }

    @GetMapping("/Glechau/reworkData")
    public String getJson() throws IOException, JSONException {
        return reworkService.getPayload();
    }

    @PostMapping("/saveFeedback")
    private long saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveOrUpdate(feedback);
        return feedback.getId();
    }

}
