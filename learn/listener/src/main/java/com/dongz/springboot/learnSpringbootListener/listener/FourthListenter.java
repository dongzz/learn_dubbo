package com.dongz.springboot.learnSpringbootListener.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * @author dong
 * @date 2020/5/11 16:33
 * @desc
 */
@Order(4)
public class FourthListenter implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return ApplicationStartedEvent.class.isAssignableFrom(aClass) ||
                ApplicationReadyEvent.class.isAssignableFrom(aClass) ||
                ApplicationPreparedEvent.class.isAssignableFrom(aClass);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("hello fourth");
    }
}
