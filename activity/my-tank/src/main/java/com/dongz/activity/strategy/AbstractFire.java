package com.dongz.activity.strategy;

import com.dongz.activity.entities.Tank;

/**
 * @Auth dz
 * @time 2020/6/22 16:54
 * @desc 开火的策略模式
 */
public interface AbstractFire {
    void start(Tank tank);
}
