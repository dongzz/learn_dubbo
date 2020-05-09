package com.dongz.springboot.learn.multicaster;

import org.springframework.stereotype.Component;

/**
 * @author dong
 * @date 2020/5/9 13:39
 * @desc
 */
@Component
public class WeatherEventMulticaster extends AbstractEventMulticaster {
    @Override
    void doStart() {
        System.out.println("begin broadcast weather");
    }

    @Override
    void doEnd() {
        System.out.println("end broadcast weather");
    }
}
