package com.dongz.learn.simpleFactory;

/**
 * @Auth dz
 * @time 2020/6/23 13:47
 * @desc 简单工厂 可扩展性不高
 */
public class SimpleCarFactory {
    public static Moveable createCar1() {
        return new Car1();
    }

    public static Moveable createCar2() {
        return new Car2();
    }
}
