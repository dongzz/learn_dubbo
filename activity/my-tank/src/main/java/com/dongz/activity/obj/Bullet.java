package com.dongz.activity.obj;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

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
        this.group = group;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
