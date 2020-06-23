package com.dongz.learn.abstractFactroy;

import com.dongz.learn.abstractFactroy.enitiy.abstracts.Food;
import com.dongz.learn.abstractFactroy.enitiy.abstracts.Weapon;

/**
 * @Auth dz
 * @time 2020/6/23 13:55
 * @desc
 */
public abstract class AbstractFactory {
    public abstract Food createFood();
    public abstract Weapon createWeapon();
}
