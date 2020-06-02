package com.dongz.learn.boot.initializer;

import com.dongz.learn.boot.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // spring--------- applicationContext.xml
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();

        // springMVC------ spring-mvc.xml  注册servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        // 把servlet注册给tomcat
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.setLoadOnStartup(1);
        // dispatchServlet访问路径
        app.addMapping("*.do");
    }
}
