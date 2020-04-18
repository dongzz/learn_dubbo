package com.dongz.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dong
 * @date 2020/4/17 17:20
 * ConditionalOnWebApplication //web应用才生效
 * @desc
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(TestProperties.class)
public class TestAutoConfiguration {

    @Autowired
    TestProperties testProperties;

    @Bean
    public TestService testService() {
        TestService testService = new TestService();
        testService.setTestProperties(testProperties);
        return testService;
    }
}
