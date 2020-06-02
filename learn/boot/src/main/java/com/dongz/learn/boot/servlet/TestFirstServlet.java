package com.dongz.learn.boot.servlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class TestFirstServlet implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("------------");
        ServletRegistration.Dynamic servlet = servletContext.addServlet("index", new FirstServlet());
        servlet.addMapping("/index");
    }
}
