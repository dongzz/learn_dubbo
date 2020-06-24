package com.dongz.learn.entities;

import lombok.Data;

/**
 * @Auth dz
 * @time 2020/6/24 9:48
 * @desc
 */
@Data
public class Tank implements Moveable{
    private int x,y;

    public void move() {
        System.out.println("wuwuwuwuwuw~");
    }
}
