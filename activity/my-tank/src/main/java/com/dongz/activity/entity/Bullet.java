package com.dongz.activity.entity;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.ObjType;
import com.dongz.activity.frame.TankFrame;
import lombok.Data;

import java.awt.*;
import java.util.List;
import java.util.Optional;

/**
 * 子弹类
 */
@Data
public class Bullet extends BaseEntity {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 碰撞检测
        collidesWithObj();
        // 越界检测
        boundsCheck();
    }

    public Bullet(int x, int y, Direction dir, ObjType type) {
        super(x, y, dir, type);
    }

    public void move() {
        switch (dir) {
            case Left:
                x -= this.type.getStep();
                break;
            case Right:
                x += this.type.getStep();
                break;
            case Up:
                y -= this.type.getStep();
                break;
            case Down:
                y += this.type.getStep();
                break;
            default:
                break;
        }
    }

    private void collidesWithObj() {
        // 获取敌军
        List<ObjType> enemies = ObjType.getEnemy(this.type);
        Optional<BaseEntity> first = TankFrame.me.objs.parallelStream().filter(item -> enemies.contains(item.getType()) && getRectangle().intersects(item.getRectangle())).findFirst();
        if (first.isPresent()) {
            BaseEntity obj = first.get();
            obj.life -= life;
            if (obj.life <= 0) {
                obj.setLive(false);
            }
            setLive(false);
        }
    }

    private void boundsCheck() {
        if (x < 0 || y < 0 || x > TankFrame.me.sizeX || y > TankFrame.me.sizeY) {
            this.isLive = false;
        }
    }
}
