package com.web.api;

import com.web.getModel.MerGet_Data;
import com.web.model.MerM_Data;
import com.web.model.Mer_Yoink;
import com.web.postModel.Mer_Data;
import com.web.model.Feedback;


import com.web.service.FeedbackService;

import com.web.service.Mer_Service_data;
import com.web.service.Mer_Service_yoink;
import com.web.service.ReworkService;
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
    }

    @GetMapping("/Meerane/reworkData")
    private List<String> getAllDataMeeranes() {
        return mer_service_data.getAllMerData();
    }

    @GetMapping("Meerane/all")
    private MerGet_Data getallYoinksMer() {
        mer_service_data.getAllMerData();
      mer_service_yoink.getAllMerYoink();

    MerGet_Data w = new MerGet_Data();
    w.data =  mer_service_data.getAllMerData();
    w.yoink = mer_service_yoink.getAllMerYoink();

        return w;
    }


    @PostMapping("/saveFeedback")
    private long saveFeedback(@RequestBody Feedback feedback) {
        feedbackService.saveOrUpdate(feedback);
        return feedback.getId();
    }

}
