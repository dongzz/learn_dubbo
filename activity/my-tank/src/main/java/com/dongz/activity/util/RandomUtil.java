package com.dongz.activity.util;

import java.util.Random;

/**
 * @Auth dz
 * @time 2020/6/19 11:50
 * @desc 概率 随机数
 */
public class RandomUtil {
    private static Random r = new Random();

    public static boolean getRandom() {
        return getRandom(95);
    }

    public static boolean getRandom(int pro) {
        if (pro > 100) pro = 100;
        return getRandom(100, pro);
    }

    public static boolean getRandom(int all, int pro) {
        if (all < pro) all = pro;
        return r.nextInt(all) > pro;
    }

    public static int getRandomNum(int all) {
        return r.nextInt(all);
    }
}
