package com.web.api;

import com.web.getModel.MerGet_Data;
import com.web.model.*;


import com.web.service.*;

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

    @Autowired
    Mer_Service_data mer_service_data;

    @Autowired
    Mer_Service_yoink mer_service_yoink;

    @Autowired
    Mer_Service_trailers mer_service_trailers;


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
        return feedbackService.getAllFeedbacks();
    }

    @RequestMapping(
            value = "/Glechau/reworkData",
            method = RequestMethod.POST)
    public void merData(@RequestBody List<String> merData) {

        mer_service_data.deleteAll();
        reworkService.save(merData);

        for (String a : merData) {
            Mer_Data mer_data = new Mer_Data();
            mer_data.setData(a);
            mer_service_data.saveOrUpdate(mer_data);
        }
    }


    @RequestMapping(
            value = "/Meerane/trailers",
            method = RequestMethod.POST)
    public void herTrailers(@RequestBody List<String> merData) {

        mer_service_trailers.deleteAll();
        reworkService.saveLwk(merData);
        for (String a : merData) {
            Mer_Trailers mer_trailers = new Mer_Trailers();
            mer_trailers.setTrailers(a);
            mer_service_trailers.saveOrUpdate(mer_trailers);
        }
    }

    @GetMapping("/Glechau/reworkData")
    private String meeraneGetDataReworks() throws IOException, JSONException {
        return reworkService.getPayload();
             }

    @GetMapping("/Meerane/trailers")
    private String meeraneGetDataTrailers() throws IOException, JSONException {
        return reworkService.getPayloadLwk();
    }

    @GetMapping("Meerane/all")
    private MerGet_Data getAllMerData() {
        mer_service_data.getAll();
        mer_service_yoink.getAll();
        mer_service_trailers.getAll();

        MerGet_Data w = new MerGet_Data();
        w.data = mer_service_data.getAll();
        w.yoink = mer_service_yoink.getAll();
        w.trailers = mer_service_trailers.getAll();
        return w;
    }

    @PostMapping("/saveFeedback")
    private long saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveOrUpdate(feedback);
        return feedback.getId();
    }
}
