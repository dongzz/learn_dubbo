package com.dongz.springboot.learn.listener;

import com.dongz.springboot.learn.event.WeatherEvent;

/**
 * @author dong
 * @date 2020/5/9 13:30
 * @desc
 */
public interface WeatherListener {
    void onWeatherEvent(WeatherEvent event);
}
