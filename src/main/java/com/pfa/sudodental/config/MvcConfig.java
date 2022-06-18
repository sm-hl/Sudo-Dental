package com.pfa.sudodental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/Dashboard");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/error404").setViewName("error/404");
        registry.addViewController("/error500").setViewName("error/500");
    }

}
