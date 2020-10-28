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

@CrossOrigin(origins = "https://indplatform", maxAge = 3600)
@Controller
@RequestMapping("/")
public class RequestController {


    @Autowired
    private Environment environment;

    @Autowired
    FeedbackService db;

    @Value("${fileStorage.path}")
    public String uploadDir;

    @ModelAttribute("profile")
    public String activeProfile() {
        return environment.getProperty("mini.ip");
    }

    @GetMapping("/feedback")
    public String nav_feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost() {
        System.out.println("user logged in");
        return "home";
    }

    @GetMapping("/resultTable")
    public String resultTable(Model model) {

        model.addAttribute("ip", environment.getProperty("mini.ip"));
        model.addAttribute("port", environment.getProperty("server.port"));

        return "resultTable";
    }


    @GetMapping("/history")
    public String history(Model model) {

        model.addAttribute("ip", environment.getProperty("mini.ip"));
        model.addAttribute("port", environment.getProperty("server.port"));

        return "history";
    }

    @PostMapping("/feedback")
    public String nav_feedback_result(@ModelAttribute Feedback nav_feedback, @RequestParam("file") MultipartFile file) throws IOException {

        Functions function = new Functions();
        System.out.println(nav_feedback.getId());
        if (!file.isEmpty()) {
            nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadDir, environment.getProperty("mini.os")));
        }

        nav_feedback.setProgress(false);
        nav_feedback.setDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(nav_feedback);
        db.saveOrUpdate(nav_feedback);
        return "feedback_result";
    }

            @GetMapping("/files/{filename:.+}")
            @ResponseBody
            public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
                System.out.println("filename: " + filename);
                System.out.println("uploadDir: " + uploadDir);
                Resource file = new FileSystemResource(uploadDir + filename);

                return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,

                        "attachment; filename=\"" + file.getFilename() + "\"").body(file);
            }
}
