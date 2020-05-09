package com.dongz.springboot.learn.multicaster;

import com.dongz.springboot.learn.event.WeatherEvent;
import com.dongz.springboot.learn.listener.WeatherListener;

/**
 * @author dong
 * @date 2020/5/9 13:34
 * @desc
 */
public interface EventMulticaster {
    void multicastEvent(WeatherEvent event);

    void addLister(WeatherListener listener);

    void removeLister(WeatherListener listener);
}
