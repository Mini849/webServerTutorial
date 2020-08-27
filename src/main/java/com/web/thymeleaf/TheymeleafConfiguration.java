package com.web.thymeleaf;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Configurable
public class TheymeleafConfiguration {

    @Bean
    public SpringTemplateEngine thymeleafLayoutDialect(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect());
        return engine;
    }

    @Bean(name="multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multi = new CommonsMultipartResolver();
        multi.setMaxUploadSize(100000);

        return multi;
    }
}
