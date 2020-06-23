package com.dongz.learn.abstractFactroy.enitiy;

import com.dongz.learn.abstractFactroy.enitiy.abstracts.Weapon;

/**
 * @Auth dz
 * @time 2020/6/23 14:01
 * @desc
 */
public class AK47 extends Weapon {
    @Override
    public void shoot() {
        System.out.println("kakakaka~");
    }
}
