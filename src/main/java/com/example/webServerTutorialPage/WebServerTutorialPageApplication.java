package com.example.webServerTutorialPage;



import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebServerTutorialPageApplication {


    public static void main(String[] args) {

		Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./data/employees", "sa", null).load();
		flyway.clean();

        SpringApplication.run(WebServerTutorialPageApplication.class, args);
    }
}
