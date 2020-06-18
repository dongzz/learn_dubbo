package com.dongz.activity.emnu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum Direction {
    Up(0, "上","U"),
    Left(1, "左", "L"),
    Down(2, "下", "D"),
    Right( 3,"右", "R");
    int value;
    String name;
    String fix;

    private static Random r = new Random();

    public static Direction getRandomDir() {
        return values()[r.nextInt(Direction.values().length)];
    }
}
