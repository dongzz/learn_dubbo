package com.dongz.activity.emnu;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Direction {
    Up(0, "上"),
    Left(1, "左"),
    Down(2, "下"),
    Right( 3,"右");
    int value;
    String name;
}
