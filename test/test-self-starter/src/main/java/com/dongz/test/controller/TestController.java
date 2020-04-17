package com.dongz.test.controller;

import com.dongz.starter.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dong
 * @date 2020/4/17 17:37
 * @desc
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return testService.testStarter("hello dongz");
    }
}
