package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
public class VersionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        servletResponse.setContentType(request.getHeader("Accept"));
        HeaderMapRequestWrapper requestParameterWrapper = new HeaderMapRequestWrapper(request);
        requestParameterWrapper.addHeader("Accept", "application/vnd.com.demo.v1+json;charset=utf-8");
        System.out.println(1);
        Enumeration<String> a = requestParameterWrapper.getHeaders("Accept");
        while (a.hasMoreElements()) {
            System.out.println(a.nextElement());
        }
        filterChain.doFilter(requestParameterWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
