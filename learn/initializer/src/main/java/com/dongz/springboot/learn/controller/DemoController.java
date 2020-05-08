package com.dongz.springboot.learn.controller;

import com.dongz.springboot.learn.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dong
 * @date 2020/5/8 13:58
 * @desc
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @Resource
    DemoService service;

    @RequestMapping("test")
    public String test() {
        return service.test();
    }
}
