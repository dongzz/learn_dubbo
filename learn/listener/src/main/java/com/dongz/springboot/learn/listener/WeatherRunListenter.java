package com.dongz.springboot.learn.listener;

import com.dongz.springboot.learn.event.RainEvent;
import com.dongz.springboot.learn.event.SnowEvent;
import com.dongz.springboot.learn.multicaster.WeatherEventMulticaster;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author dong
 * @date 2020/5/11 14:55
 * @desc
 */
@Component
public class WeatherRunListenter {

    @Resource
    WeatherEventMulticaster multicaster;

    public void snow() {
        multicaster.multicastEvent(new SnowEvent());
    }
    public void rain() {
        multicaster.multicastEvent(new RainEvent());
    }

}
