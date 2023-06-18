package com.example.demo.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration

public class ConfigurationMapping implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/contact").setViewName("contact");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/course").setViewName("course");
        registry.addViewController("/Register").setViewName("Register");

    }

}

