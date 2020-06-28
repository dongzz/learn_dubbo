package com.dongz.learn;

import com.dongz.learn.dynamicProxyCglib.DemoProxy2;
import com.dongz.learn.dynamicProxyJdk.DemoProxy;
import com.dongz.learn.entities.Moveable;
import com.dongz.learn.entities.Tank;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Auth dz
 * @time 2020/6/24 9:43
 * @desc
 */
public class Main {

    public static void main(String[] args) {
        //jdk动态代理
        Moveable t = DemoProxy.getT(Tank.class, Moveable.class);
        t.move();
        //cglib动态代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new DemoProxy2());
        Tank tank = (Tank)enhancer.create();
        tank.move();
    }
}
