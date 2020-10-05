package com.web.service;


import com.web.model.Feedback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class Functions {

    @Value("${server.port}")
    public int port;

    @Value("${admin.name}")
    public String name;

    @Value("${admin.pass}")
    public String pass;

    @Value("${mini.os}")
    public String backlash;

    public String saveFile(MultipartFile file, Feedback nav_feedback, String path) throws IOException {

        String filetype = "." + Objects.requireNonNull(file.getContentType()).split("/")[1]; //don't change it you stupid, tis good


        file.transferTo(Paths.get(path + backlash + "pic" + nav_feedback.getId() + filetype));
        return (backlash + "files" + backlash + "pic" + nav_feedback.getId() + filetype);
    }


    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }


}
