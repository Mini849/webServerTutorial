package com.web;

import org.flywaydb.core.Flyway;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {


    @Autowired
    private static Environment environment;

    @Value("${mini.clean}")
    private static boolean clean;

    @Value("${mini.os}")
    private static String backlash;



    public static void main(String[] args) {



        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./data/employees", "sa", null).load();
        if (clean) {
            flyway.clean();
        }

        SpringApplication.run(App.class, args);


    }
}
