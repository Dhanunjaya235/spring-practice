package com.example.dhanunjay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dhanunjay.services.IApplicationContextService;
import com.example.dhanunjay.services.Impl.ApplicationContextService;

@Configuration
public class ConfigBeans {

    @Bean
    public IApplicationContextService applicationContextServiceBean() {
        System.out.println("Bean created using @Configuration and @Bean");
        return new ApplicationContextService();
    }
}
