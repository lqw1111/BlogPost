package com.example.demo.config;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
    /**
     * construct a wrapper for this request
     *
     * @param request
     */
    public HeaderMapRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    private Map<String, String> headerMap = new HashMap<>();

    /**
     * add a header with given name and value
     *
     * @param name
     * @param value
     */
    public void addHeader(String name, String value) {
        headerMap.put(name, value);
    }

    @Override
    public String getHeader(String name) {
        String headerValue = super.getHeader(name);
        if (headerMap.containsKey(name)) {
            headerValue = headerMap.get(name);
        }
        return headerValue;
    }

    /**
     * get the Header names
     */
    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        Set<String> namesSet = new HashSet<>(names);
        for (String name : headerMap.keySet()) {
            namesSet.add(name);
        }
        return Collections.enumeration(namesSet);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        Set<String> values = new HashSet<>();
        if (headerMap.containsKey(name)) {
            values.add(headerMap.get(name));
        }
        Enumeration<String> a = super.getHeaders(name);
        while (a.hasMoreElements()) {
            values.add(a.nextElement());
        }
        return Collections.enumeration(values);
    }
}

