package com.dongz.activity.emnu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
    Up(0, "上","img/tank/{name}U.gif"),
    Left(1, "左", "img/tank/{name}L.gif"),
    Down(2, "下", "img/tank/{name}D.gif"),
    Right( 3,"右", "img/tank/{name}R.gif");
    int value;
    String name;
    String fix;
}
