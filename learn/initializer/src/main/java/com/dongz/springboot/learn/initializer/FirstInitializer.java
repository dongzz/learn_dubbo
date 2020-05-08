package com.dongz.springboot.learn.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dong
 * @date 2020/5/8 13:52
 * @desc 系统初始化器
 */
@Order(1)
public class FirstInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 获取环境
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        MapPropertySource mapPropertySource = new MapPropertySource("firstInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("run firstInitializer");
    }
}
