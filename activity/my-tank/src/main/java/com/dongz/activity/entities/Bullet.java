package com.dongz.activity.entities;

import com.dongz.activity.enums.Direction;
import com.dongz.activity.enums.ObjType;
import com.dongz.activity.frames.MainFrame;
import lombok.Data;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 子弹类
 */
@Data
public class Bullet extends BaseEnemy {
    // 打出子弹的tank
    public Tank tank;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 碰撞检测
        collidesWithObj();
        // 越界检测
        boundsCheck();
    }

    public Bullet(int x, int y, Direction dir, ObjType type, Tank tank) {
        super(x, y, dir, type);
        this.tank = tank;
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
        // 获取障碍物
        List<ObjType> obstacles = ObjType.getObstacles();
        Rectangle rectangle = this.getRectangle();
        ObjType type = this.getType();
        Tank tank = this.tank;
        Optional<BaseEntity> first = MainFrame.me.objs.parallelStream().filter(e -> e.getType().getCamp() != 4)
                .filter(item -> !type.equals(item.getType()) && obstacles.contains(item.getType()) &&
                !item.equals(tank) && rectangle.intersects(item.getRectangle())).findFirst();
        if (first.isPresent()) {
            BaseEntity obj = first.get();
            // 判断是否是友军
            if (obj.getType().getCamp() != this.getType().getCamp()) {
                // 计算伤害值
                obj.life -= life;
                if (obj.life <= 0) {
                    obj.setLive(false);
                    MainFrame.me.objs.add(new Explode(obj.getX(), obj.getY()));
                }
            }
            setLive(false);
        }
    }

    private void boundsCheck() {
        if (x < 0 || y < 0 || x > MainFrame.me.sizeX || y > MainFrame.me.sizeY) {
            this.isLive = false;
        }
    }
}
