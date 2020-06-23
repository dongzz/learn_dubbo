package com.dongz.learn;

import com.dongz.learn.abstractFactroy.AbstractFactory;
import com.dongz.learn.abstractFactroy.MagicFactory;
import com.dongz.learn.abstractFactroy.ModernFactory;
import com.dongz.learn.abstractFactroy.enitiy.abstracts.Food;
import com.dongz.learn.abstractFactroy.enitiy.abstracts.Weapon;
import com.dongz.learn.simpleFactory.Car1;
import com.dongz.learn.simpleFactory.Car2;
import com.dongz.learn.simpleFactory.SimpleCarFactory;

/**
 * @Auth dz
 * @time 2020/6/23 13:47
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        // 简单工程
        Car1 car1 = SimpleCarFactory.createCar1();
        car1.show();
        Car2 car2 = SimpleCarFactory.createCar2();
        car2.show();
        Car1 car11 = SimpleCarFactory.createCar1();
        System.out.println(car1 == car11);
        // 抽象工程 生产一个族的类
        // 现代工厂
        AbstractFactory modernFactory = new ModernFactory();
        Food food1 = modernFactory.createFood();
        food1.eat();
        Weapon weapon1 = modernFactory.createWeapon();
        weapon1.shoot();
        // 魔法工厂
        AbstractFactory magicFactory = new MagicFactory();
        Food food2 = magicFactory.createFood();
        food2.eat();
        Weapon weapon2 = magicFactory.createWeapon();
        weapon2.shoot();
    }
}
