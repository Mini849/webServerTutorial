package com.example.webServerTutorialPage.api;

import com.example.webServerTutorialPage.model.Feedback;

import com.example.webServerTutorialPage.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;


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

    @GetMapping("/resultTable")
    public String resultTable() {
        return "resultTable";
    }

    @GetMapping("/nav_base_inputs")
    public String nav_base_inputs() {
        return "nav_base_inputs";
    }

    @GetMapping("/nav_feedback")
    public String nav_feedbackForm(Model model) {
        model.addAttribute("nav_feedback", new Feedback());
        return "nav_feedback";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String loginPost() {
        System.out.println("user logged in");
        return "hello";
    }


    @PostMapping("/nav_feedback")
    public String nav_feedback_result(@ModelAttribute Feedback nav_feedback, @RequestParam("file") MultipartFile file) {

        Functions function = new Functions();
        String uploadDir = "D:\\GitProjects\\webServerTutorialPage\\src\\main\\resources\\files";
        String uploadDirLocalPC = "E:\\GitHub\\site\\src\\main\\resources\\files";

        if (!file.isEmpty()) {

            try {
                nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadDir));
            } catch (Exception e) {
//                e.printStackTrace();
            }

            try {
                nav_feedback.setFilepath(function.saveFile(file, nav_feedback, uploadDirLocalPC));
            } catch (Exception e) {
//                e.printStackTrace();
            }

        }





        nav_feedback.setProgress(0);


        nav_feedback.setDate(function.getTimestampWithGMT);

        System.out.println(nav_feedback);
        db.saveOrUpdate(nav_feedback);
        return "nav_feedback_result";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = new FileSystemResource("E:\\GitHub\\site\\src\\main\\resources\\files\\" + filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
