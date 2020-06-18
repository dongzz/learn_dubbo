package com.dongz.activity.obj;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;
import com.dongz.activity.frame.TankFrame;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;
import java.util.Optional;

/**
 * 子弹类
 */
@Data
@NoArgsConstructor
public class Bullet extends BaseObj {

    public Bullet(int x, int y, Direction dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = true;
        this.isLive = true;
        this.group = group;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 碰撞检测
        collidesWithObj();
        // 越界检测
        boundsCheck();
    }

    public void move() {
        switch (dir) {
            case Left:
                x -= this.group.getStep();
                break;
            case Right:
                x += this.group.getStep();
                break;
            case Up:
                y -= this.group.getStep();
                break;
            case Down:
                y += this.group.getStep();
                break;
            default:
                break;
        }
    }

    private void collidesWithObj() {
        // 获取敌军
        List<Group> enemies = Group.getEnemy(this.group);
        Optional<BaseObj> first = TankFrame.me.objs.parallelStream().filter(item -> enemies.contains(item.getGroup()) && getRectangle().intersects(item.getRectangle())).findFirst();
        if (first.isPresent()) {
            first.get().setLive(false);
            setLive(false);
        }
    }

    private void boundsCheck() {
        if (x < 0 || y < 0 || x > TankFrame.me.sizeX || y > TankFrame.me.sizeY) {
            this.isLive = false;
        }
    }
}
