package com.web.api;

import com.web.model.Feedback;

import com.web.service.FeedbackService;
import com.web.service.Functions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/")
public class RequestController {

    @Autowired
    FeedbackService db;

    String uploadDir = "D:\\GitProjects\\webServerTutorialPage\\src\\main\\resources\\files";
    String uploadDirLocalPC = "E:\\GitHub\\site\\src\\main\\resources\\files";
    String uploadServer = "\\indplatform\\rampup\\db\\files";

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
    public String nav_feedback_result(@ModelAttribute Feedback nav_feedback, @RequestParam("file") MultipartFile file) {

        Functions function = new Functions();



        if (!file.isEmpty()) {

            try {
                nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadDir));
            } catch (Exception e) {
            }

            try {
                nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadDirLocalPC));
            } catch (Exception e) {
            }

            try {
                nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadServer));
            } catch (Exception e) {

            }
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

        Resource file = new FileSystemResource(uploadServer + filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
