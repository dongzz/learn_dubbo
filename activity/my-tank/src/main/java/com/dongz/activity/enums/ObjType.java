package com.dongz.activity.enums;

import com.dongz.activity.utils.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类型
 */
@Getter
@AllArgsConstructor
public enum ObjType {
    P1(1,1,"友军", "images/tank/p1tank%s.gif", 5, 1, true),
    P2(1,1,"友军", "images/tank/p2tank%s.gif", 5, 1, true),
    ENEMY1(2,2,"敌军", "images/tank/enemy1%s.gif", 8, 1, true),
    ENEMY2(2,2,"敌军", "images/tank/enemy2%s.gif", 7, 1, true),
    ENEMY3(2,2,"敌军", "images/tank/enemy3%s.gif", 6, 2, true),
    ENEMY4(2,2,"敌军", "images/tank/enemy4%s.gif", 5, 2, true),
    ENEMY5(2,2,"敌军", "images/tank/enemy5%s.gif", 4, 3, true),
    ENEMY6(2,2,"敌军", "images/tank/enemy6%s.gif", 4, 3, true),
    BULLET(3,1,"友军子弹", "images/bullet/bullet%s.gif", 10, 1, false),
    ENEMYBULLET(3,2, "敌军子弹", "images/bullet/bullet%s.gif", 10, 1, false);

    int code; // 类型 1：玩家， 2： 敌军 ，3：子弹
    int camp; // 阵营
    String name;
    String img; //图片
    int step; // 速递
    int life;// tank：生命值 子弹：伤害
    boolean isObstacle; //是否是障碍物

    public static List<ObjType> getP() {
        return Arrays.stream(ObjType.values()).filter(e -> e.getCode() == 1).collect(Collectors.toList());
    }

    public static List<ObjType> getEnemyTank() {
        return Arrays.stream(ObjType.values()).filter(e -> e.getCode() == 2).collect(Collectors.toList());
    }

    public static List<ObjType> getObstacles() {
        return Arrays.stream(ObjType.values()).filter(ObjType::isObstacle).collect(Collectors.toList());
    }

    public static List<ObjType> getFamily(ObjType type) {
        return Arrays.stream(ObjType.values()).filter(e -> e.getCamp() == type.getCamp() && !e.equals(type)).collect(Collectors.toList());
    }


    public static List<ObjType> getEnemy(ObjType type) {
        return Arrays.stream(ObjType.values()).filter(e -> e.getCamp() != type.getCamp()).collect(Collectors.toList());
    }

    public static List<ObjType> getEnemyUnit() {
        return Arrays.stream(ObjType.values()).filter(e -> e.getCamp() == 2).collect(Collectors.toList());
    }

    public static ObjType getRandomEnemy() {
        return getEnemyTank().get(RandomUtil.getRandomNum(getEnemyTank().size()));
    }

}
