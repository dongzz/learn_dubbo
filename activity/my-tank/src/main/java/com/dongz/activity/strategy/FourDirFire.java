package com.dongz.activity.strategy;

import com.dongz.activity.entities.Bullet;
import com.dongz.activity.entities.Tank;
import com.dongz.activity.enums.Direction;
import com.dongz.activity.enums.ObjType;
import com.dongz.activity.frames.MainFrame;

import java.util.Arrays;

/**
 * @Auth dz
 * @time 2020/6/22 16:55
 * @desc
 */
public class FourDirFire implements AbstractFire {

    public void start(Tank tank) {
        Arrays.stream(Direction.values()).forEach(e ->
            MainFrame.me.objs.add(new Bullet(tank.getX(), tank.getY(), e, ObjType.getBullets(tank.getType()), tank))
        );
    }
}
