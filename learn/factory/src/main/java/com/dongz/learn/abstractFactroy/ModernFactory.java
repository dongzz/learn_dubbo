package com.dongz.learn.abstractFactroy;

import com.dongz.learn.abstractFactroy.enitiy.AK47;
import com.dongz.learn.abstractFactroy.enitiy.Bread;
import com.dongz.learn.abstractFactroy.enitiy.interfaces.Food;
import com.dongz.learn.abstractFactroy.enitiy.interfaces.Weapon;

/**
 * @Auth dz
 * @time 2020/6/23 14:07
 * @desc
 */
public class ModernFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
