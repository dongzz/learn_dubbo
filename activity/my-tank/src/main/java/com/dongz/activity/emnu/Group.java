package com.dongz.activity.emnu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<Group> getP() {
        return Arrays.stream(Group.values()).filter(e -> e.getCode() == 1).collect(Collectors.toList());
    }

    public static List<Group> getFamily(Group group) {
        return Arrays.stream(Group.values()).filter(e -> e.getCamp() == group.getCamp() && !e.equals(group)).collect(Collectors.toList());
    }


    public static List<Group> getEnemy(Group group) {
        return Arrays.stream(Group.values()).filter(e -> e.getCamp() != group.getCamp()).collect(Collectors.toList());
    }

}
