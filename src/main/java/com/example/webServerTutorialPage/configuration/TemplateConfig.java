package com.example.webServerTutorialPage.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TemplateConfig  implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/nav_about").setViewName("base_inputs/nav_about");
        registry.addViewController("/nav_download").setViewName("nav_download");
        registry.addViewController("/nav_tutorial").setViewName("nav_tutorial");
        registry.addViewController("/nav_home").setViewName("nav_home");
        registry.addViewController("/").setViewName("hello");
        registry.addViewController("/nav_base_inputs").setViewName("nav_base_inputs");
        registry.addViewController("/login").setViewName("login");
    }
}
