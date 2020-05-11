package com.dongz.springboot.learn.controller;

import com.dongz.springboot.learn.listener.WeatherRunListenter;
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
public class Demo2Controller {

    @Resource
    WeatherRunListenter listenter;

    @RequestMapping("/snow")
    public void addSnow(){
        listenter.snow();
    }

    @RequestMapping("/rain")
    public void addRain(){
        listenter.rain();
    }
}
