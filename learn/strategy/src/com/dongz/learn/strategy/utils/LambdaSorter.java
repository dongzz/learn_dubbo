package com.dongz.learn.strategy.utils;

import java.util.Arrays;

/**
 * @Auth dz
 * @time 2020/6/22 23:45
 * @desc
 */
public class LambdaSorter implements Sorter {
    @Override
    public void sort(int[] a) {
        int[] ints = Arrays.stream(a).sorted().toArray();
        System.arraycopy(ints, 0, a, 0, ints.length);
    }
}
