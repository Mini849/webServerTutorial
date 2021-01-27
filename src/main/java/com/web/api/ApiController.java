package com.web.api;

import com.web.getModel.MerGet_Data;
import com.web.model.MerM_Data;
import com.web.model.Mer_Trailers;
import com.web.model.Mer_Yoink;
import com.web.postModel.Mer_Data;
import com.web.model.Feedback;


import com.web.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;


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
            value = "/Meerane/reworkData",
            method = RequestMethod.POST)
    public void process(@RequestBody Mer_Data merData) {

        mer_service_data.deleteAll();
        mer_service_yoink.deleteAll();
        mer_service_trailers.deleteAll();

        for (String a : merData.getData()) {
            MerM_Data merM_data = new MerM_Data();
            merM_data.setData(a);
            mer_service_data.saveOrUpdate(merM_data);
        }

        for (String a : merData.getYoink()) {
            Mer_Yoink mer_yoink = new Mer_Yoink();
            mer_yoink.setYoink(a);
            mer_service_yoink.saveOrUpdate(mer_yoink);
        }

        for (String a : merData.getTrailers()) {
            Mer_Trailers mer_trailers = new Mer_Trailers();
            mer_trailers.setTrailers(a);
            mer_service_trailers.saveOrUpdate(mer_trailers);
        }


    }

    @GetMapping("/Meerane/reworkData")
    private List<String> getAllDataMeeranes() {
        return mer_service_data.getAll();
    }

    @GetMapping("Meerane/all")
    private MerGet_Data getAllMerData() {
        mer_service_data.getAll();
        mer_service_yoink.getAll();

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
