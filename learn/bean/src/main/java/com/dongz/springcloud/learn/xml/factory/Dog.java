package com.dongz.springcloud.learn.xml.factory;

import org.springframework.stereotype.Component;

/**
 * @author dong
 * @date 2020/5/11 17:58
 * @desc
 */
@Component
public class Dog extends Animal {
    @Override
    public String getName() {
        return "Dog";
    }
}
