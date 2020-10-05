package com.web.api;

import com.web.model.Feedback;

import com.web.service.FeedbackService;
import com.web.service.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/")
public class RequestController {

    @Autowired
    private Environment environment;

    @Autowired
    FeedbackService db;

    @Value("${fileStorage.path}")
    public String uploadDir;



    public String backlash;


    @GetMapping("/nav_feedback")
    public String nav_feedbackForm(Model model) {
        model.addAttribute("nav_feedback", new Feedback());
        return "nav_feedback";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost() {
        System.out.println("user logged in");
        return "hello";
    }

    @PostMapping("/nav_feedback")
    public String nav_feedback_result(@ModelAttribute Feedback nav_feedback, @RequestParam("file") MultipartFile file) throws IOException {

        Functions function = new Functions();

        System.out.println(environment.getProperty("mini.os"));
        if (!file.isEmpty()) {
            nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadDir));
        }


        nav_feedback.setProgress(false);
        nav_feedback.setDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(nav_feedback);
        db.saveOrUpdate(nav_feedback);
        return "nav_feedback_result";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = new FileSystemResource(uploadDir + filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + backlash + file.getFilename() + backlash).body(file);  //windows ?
//                          "attachment; filename=/" + file.getFilename() + "/").body(file);   //linux ?
    }
}
