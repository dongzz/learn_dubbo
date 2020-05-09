package com.dongz.springboot.learn.listener;

import com.dongz.springboot.learn.event.SnowEvent;
import com.dongz.springboot.learn.event.WeatherEvent;
import org.springframework.stereotype.Component;

/**
 * @author dong
 * @date 2020/5/9 13:32
 * @desc
 */
@Component
public class SnowListener implements WeatherListener{
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof SnowEvent) {
            System.out.println("hello "+ event);
        }
    }
}
