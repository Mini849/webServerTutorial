package com.example.webServerTutorialPage.api;

import com.example.webServerTutorialPage.model.Feedback;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.TimeZone;

public class Functions {

    public String getTimestampWithGMT;

    private static String getTimestampWithGMT() {
        long timestamp = System.currentTimeMillis() / 1000;
        int offset = (TimeZone.getDefault().getRawOffset() + TimeZone.getDefault().getDSTSavings()) / 1000;

        return String.valueOf(timestamp + offset);
    }

    public String saveFile(MultipartFile file, Feedback nav_feedback, String path) throws IOException {

        String filetype = "." + Objects.requireNonNull(file.getContentType()).split("/")[1];

        String truePath = path + "/" + "pic" + nav_feedback.getId() + filetype;

        file.transferTo(Paths.get(truePath));
        return (truePath);
    }

}
