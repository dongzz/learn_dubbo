package com.dongz.springboot;

import com.dongz.springboot.learnSpringbootListener.listener.SecondListenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LearnApplication.class, args);
        SpringApplication springApplication = new SpringApplication(LearnApplication.class);
        springApplication.addListeners(new SecondListenter());
        springApplication.run(args);
    }

}
