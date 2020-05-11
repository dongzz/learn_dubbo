package com.dongz.springcloud.learn.xml.factory;

/**
 * @author dong
 * @date 2020/5/11 18:00
 * @desc
 */
public class AnimalFactory {

    public static Animal getAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }

    public Animal getAnimals(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
