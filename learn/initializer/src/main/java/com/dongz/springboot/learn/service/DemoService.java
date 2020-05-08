package com.dongz.springboot.learn.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author dong
 * @date 2020/5/8 14:01
 * @desc
 */
@Service
public class DemoService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String test(String num) {
        return applicationContext.getEnvironment().getProperty("key" + num);
    }
}
