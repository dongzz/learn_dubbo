package com.dongz.learn.boot;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;

public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication();
        application.run();
    }


    public static class SpringApplication {
        // 启动tomcat
        public void run() {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);
            String sourcePath = Application.class.getResource("/").getPath();


            try {
                // 指定给tomcat 项目的webapp
                Context context = tomcat.addWebapp("/", new File("learn/boot/src/main/webapp").getAbsolutePath());
                // 指定给tomcat 项目class文件
                WebResourceRoot resource = new StandardRoot(context);
                resource.addPreResources(new DirResourceSet(resource, "/WEB-INF/classes", sourcePath, "/"));
                context.setResources(resource);
                tomcat.start();
                tomcat.getServer().await();
            } catch (LifecycleException | ServletException e) {
                e.printStackTrace();
            }
        }
    }
}