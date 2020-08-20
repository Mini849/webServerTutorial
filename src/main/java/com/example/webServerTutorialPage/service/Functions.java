package com.example.webServerTutorialPage.service;

import com.example.webServerTutorialPage.model.Feedback;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.TimeZone;

public class Functions {

    public String saveFile(MultipartFile file, Feedback nav_feedback, String path) throws IOException {

        String filetype = "." + Objects.requireNonNull(file.getContentType()).split("/")[1];

        file.transferTo(Paths.get(path + "/" + "pic" + nav_feedback.getId() + filetype));
        return ("/files/" + "pic" + nav_feedback.getId() + filetype);
    }
}
