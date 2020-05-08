package com.dongz.springboot.learn;

import com.dongz.springboot.learn.initializer.SecondInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LearnApplication.class, args);
        SpringApplication springApplication = new SpringApplication(LearnApplication.class);
        springApplication.addInitializers(new SecondInitializer());
        springApplication.run(args);
    }

}
