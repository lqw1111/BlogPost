package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Autowired
    private VersionFilter versionFilter;

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        System.out.println("Filter is starting!");
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(versionFilter);
        registration.addUrlPatterns("/api/*");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public Filter someFilter() {
        return new VersionFilter();
    }

}
