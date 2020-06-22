package com.dongz.activity.strategy;

import com.dongz.activity.entities.Bullet;
import com.dongz.activity.entities.Tank;
import com.dongz.activity.enums.ObjType;
import com.dongz.activity.frames.MainFrame;

/**
 * @Auth dz
 * @time 2020/6/22 16:55
 * @desc
 */
public class DefaultFire implements AbstractFire {

    public void start(Tank tank) {
        MainFrame.me.objs.add(new Bullet(tank.getX(), tank.getY(), tank.getDir(), ObjType.getBullets(tank.getType()), tank));
    }
}
