package com.dongz.learn.abstractFactroy.enitiy;

import com.dongz.learn.abstractFactroy.enitiy.abstracts.Food;

/**
 * @Auth dz
 * @time 2020/6/23 14:03
 * @desc
 */
public class Bread extends Food {
    @Override
    public void eat() {
        System.out.println("test well");
    }
}
