package com.dongz.learn;

import com.dongz.learn.dynamicProxyJdk.DemoProxy;
import com.dongz.learn.entities.Moveable;
import com.dongz.learn.entities.Tank;

/**
 * @Auth dz
 * @time 2020/6/24 9:43
 * @desc
 */
public class Main {

    public static void main(String[] args) {
        //动态代理
        Moveable t = DemoProxy.getT(Tank.class, Moveable.class);
        t.move();
    }
}
