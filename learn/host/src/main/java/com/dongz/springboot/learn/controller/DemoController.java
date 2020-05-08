package com.dongz.springboot.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @date 2020/5/8 13:58
 * @desc
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @RequestMapping("test")
    public String test() {
        return "";
    }
}
