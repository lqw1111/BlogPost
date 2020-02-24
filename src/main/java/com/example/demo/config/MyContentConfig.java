//package com.example.demo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MyContentConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        System.out.println("!!!!!!!!!!!!!!!!");
//        configurer.favorPathExtension(true).
//                favorParameter(false).
//                parameterName("mediaType").
//                ignoreAcceptHeader(false).
//                defaultContentType(MediaType.APPLICATION_JSON).
//                mediaType("json", MediaType.parseMediaType("application/*+json;v=1;charset=utf-8"));
//    }
//}
