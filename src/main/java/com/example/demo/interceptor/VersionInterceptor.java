package com.example.demo.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class VersionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String gsid = request.getHeader("GSID");
//        if(StringUtils.isBlank(gsid)){
//            String gsid= request.getParameter("GSID");
//            reflectSetparam(request,"GSID",gsid);
//        }
        return true;
    }

    private void reflectSetparam(HttpServletRequest request, String gsid, String gsid1) {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post handler");
    }
}
