package com.dongz.springcloud.learn.annotation;

import com.dongz.springcloud.learn.xml.factory.Animal;
import com.dongz.springcloud.learn.xml.factory.Cat;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author dong
 * @date 2020/5/12 09:32
 * @desc
 */
@Component
public class MyCat implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
