package com.dongz.springboot.learn.controller;

import com.dongz.springboot.learn.event.RainEvent;
import com.dongz.springboot.learn.event.SnowEvent;
import com.dongz.springboot.learn.listener.RainListener;
import com.dongz.springboot.learn.listener.SnowListener;
import com.dongz.springboot.learn.multicaster.WeatherEventMulticaster;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dong
 * @date 2020/5/9 13:43
 * @desc
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @Resource
    WeatherEventMulticaster weatherEventMulticaster;

    @Resource
    SnowListener snowListener;

    @Resource
    RainListener rainListener;

    @RequestMapping("/addSnow")
    public void addSnow(){
        weatherEventMulticaster.addLister(snowListener);
        weatherEventMulticaster.multicastEvent(new SnowEvent());
        weatherEventMulticaster.multicastEvent(new RainEvent());
    }

    @RequestMapping("/removeSnow")
    public void removeSnow(){
        weatherEventMulticaster.removeLister(snowListener);
        weatherEventMulticaster.multicastEvent(new SnowEvent());
        weatherEventMulticaster.multicastEvent(new RainEvent());
    }

    @RequestMapping("/addRain")
    public void addRain(){
        weatherEventMulticaster.addLister(rainListener);
        weatherEventMulticaster.multicastEvent(new SnowEvent());
        weatherEventMulticaster.multicastEvent(new RainEvent());
    }

    @RequestMapping("/removeRain")
    public void removeRain(){
        weatherEventMulticaster.removeLister(rainListener);
        weatherEventMulticaster.multicastEvent(new SnowEvent());
        weatherEventMulticaster.multicastEvent(new RainEvent());
    }
}
