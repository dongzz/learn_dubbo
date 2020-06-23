package com.dongz.learn.strategy;

import com.dongz.learn.strategy.utils.LambdaSorter;
import com.dongz.learn.strategy.utils.Sorter;

import java.util.Arrays;

/**
 * @Auth dz
 * @time 2020/6/22 22:24
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {9, 4, 1, 2, 6, 8, 3, 5};
        Sorter sorter = new LambdaSorter();
        sorter.sort(a);
        System.out.println(a.hashCode());
        System.out.println(Arrays.toString(a));
    }
}
