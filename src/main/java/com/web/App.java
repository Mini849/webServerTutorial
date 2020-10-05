package com.web;

import com.web.service.Functions;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
public class App {



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

        System.out.println(clean);
        System.out.println(backlash);

    }
}
