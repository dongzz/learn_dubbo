package com.dongz.activity.obj;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;
import com.dongz.activity.frame.TankFrame;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * 子弹类
 */
@Data
@NoArgsConstructor
public class Bullet extends BaseObj {
    private boolean isLive;

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
        if (x < 0 || y < 0 || x > TankFrame.me.sizeX || y > TankFrame.me.sizeY) {
            this.isLive = false;
        }
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
}
