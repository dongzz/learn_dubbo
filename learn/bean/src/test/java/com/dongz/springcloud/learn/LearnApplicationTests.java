package com.dongz.springcloud.learn;

import com.dongz.springcloud.learn.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:ioc/demo.xml")
class LearnApplicationTests {

    @Resource
    private HelloService service;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        System.out.println(service.hello());
    }

}
