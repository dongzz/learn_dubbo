package com.dongz.activity.emnu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Group {
    P1(1,1,"友军", "images/tank/p1tank%s.gif", 5),
    P2(1,1,"友军", "images/tank/p2tank%s.gif", 5),
    ENEMY1(2,2,"敌军", "images/tank/enemy1%s.gif", 5),
    ENEMY2(2,2,"敌军", "images/tank/enemy2%s.gif", 5),
    ENEMY3(2,2,"敌军", "images/tank/enemy3%s.gif", 6),
    ENEMY4(2,2,"敌军", "images/tank/enemy4%s.gif", 5),
    ENEMY5(2,2,"敌军", "images/tank/enemy5%s.gif", 6),
    ENEMY6(2,2,"敌军", "images/tank/enemy6%s.gif", 5),
    BULLET(3,1,"友军子弹", "images/bullet/bullet%s.gif", 7),
    ENEMYBULLET(3,2, "敌军子弹", "images/bullet/bullet%s.gif", 7);

    int code;
    int camp;
    String name;
    String img;
    int step;
}
