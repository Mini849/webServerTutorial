package com.example.webServerTutorialPage.api;

import com.example.webServerTutorialPage.model.Feedback;

import com.example.webServerTutorialPage.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    FeedbackService db;

    @GetMapping("/")
    public String basse() {
        return "layout";
    }

    @GetMapping("/nav_download")
    public String nav_download() {
        return "nav_download";
    }

    @GetMapping("/nav_about")
    public String nav_about() {
        return "nav_about";
    }

    @GetMapping("/nav_tutorial")
    public String nav_tutorial() {
        return "nav_tutorial";
    }

    @GetMapping("/nav_home")
    public String nav_home() {
        return "nav_home";
    }

    @GetMapping("api_resultTable")
    public String api_resultTable() {
        return "api_resultTable";
    }

    @GetMapping("/nav_feedback")
    public String nav_feedbackForm(Model model) {
        model.addAttribute("nav_feedback", new Feedback());
        return "nav_feedback";
    }

    @PostMapping("/nav_feedback")
    public String nav_feedback_result(@ModelAttribute Feedback nav_feedback, @RequestParam("file") MultipartFile file) {

        try {

            String uploadDir = "C:\\Users\\amack\\Desktop\\uploads\\";

            File transferFile = new File(uploadDir + "/" + file.getOriginalFilename());
            file.transferTo(transferFile);

        } catch (Exception e) {
            e.printStackTrace();
            return "Failure with uploading the file, please try again.";
        }


        System.out.println(nav_feedback);
        db.saveOrUpdate(nav_feedback);
        return "nav_feedback_result";
    }

}
