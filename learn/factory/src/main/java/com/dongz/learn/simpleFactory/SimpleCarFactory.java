package com.dongz.learn.simpleFactory;

/**
 * @Auth dz
 * @time 2020/6/23 13:47
 * @desc 简单工厂 可扩展性不高
 */
public class SimpleCarFactory {
    public static Car1 createCar1() {
        return new Car1();
    }

    public static Car2 createCar2() {
        return new Car2();
    }
}
