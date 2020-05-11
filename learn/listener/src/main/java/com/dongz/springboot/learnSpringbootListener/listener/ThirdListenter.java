package com.dongz.springboot.learnSpringbootListener.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * @author dong
 * @date 2020/5/11 16:33
 * @desc
 */
@Order(3)
public class ThirdListenter implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("hello Third");
    }
}
