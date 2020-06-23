package com.dongz.learn.abstractFactroy;

import com.dongz.learn.abstractFactroy.enitiy.MagicStick;
import com.dongz.learn.abstractFactroy.enitiy.MushRoom;
import com.dongz.learn.abstractFactroy.enitiy.interfaces.Food;
import com.dongz.learn.abstractFactroy.enitiy.interfaces.Weapon;

/**
 * @Auth dz
 * @time 2020/6/23 14:07
 * @desc
 */
public class MagicFactory extends AbstractFactory {
    @Override
    public Food createFood() {
        return new MushRoom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }
}
