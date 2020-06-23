package com.dongz.learn.abstractFactroy.enitiy;

import com.dongz.learn.abstractFactroy.enitiy.interfaces.Weapon;

/**
 * @Auth dz
 * @time 2020/6/23 14:01
 * @desc
 */
public class AK47 implements Weapon {
    @Override
    public void shoot() {
        System.out.println("kakakaka~");
    }
}
