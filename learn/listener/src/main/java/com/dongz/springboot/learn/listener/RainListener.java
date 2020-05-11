package com.dongz.springboot.learn.listener;

import com.dongz.springboot.learn.event.RainEvent;
import com.dongz.springboot.learn.event.WeatherEvent;
import org.springframework.stereotype.Component;

/**
 * @author dong
 * @date 2020/5/9 13:32
 * @desc
 */
@Component
public class RainListener implements WeatherListener{
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println("hello "+ event.getWeatherEvent());
        }
    }
}
