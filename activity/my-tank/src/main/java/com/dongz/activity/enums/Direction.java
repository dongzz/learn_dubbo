package com.dongz.activity.enums;

import com.dongz.activity.utils.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

    public static Direction getRandomDir() {
        return values()[RandomUtil.getRandomNum(Direction.values().length)];
    }
}
