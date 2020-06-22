package com.dongz.activity.entities;

import com.dongz.activity.enums.Direction;
import com.dongz.activity.enums.ObjType;
import com.dongz.activity.frames.MainFrame;
import com.dongz.activity.utils.RandomUtil;
import lombok.Data;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

@Data
public class Tank extends BaseEnemy {
    private boolean Dl, Dr, Du, Dd;

    private Bullet bullet;

    public Tank(int x, int y, Direction dir, ObjType type) {
        super(x, y, dir, type);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void keyPressed(KeyEvent e) {
        clearDir();
        switchPo(e, true);
        switchDir();
    }

    public void keyReleased(KeyEvent e) {
        switchPo(e, false);
        switchDir();
    }

    private void switchPo(KeyEvent e, boolean move) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                Dl = move;
                break;
            case KeyEvent.VK_RIGHT:
                Dr = move;
                break;
            case KeyEvent.VK_UP:
                Du = move;
                break;
            case KeyEvent.VK_DOWN:
                Dd = move;
                break;
            case KeyEvent.VK_CONTROL:
                if (move) {
                    this.fire();
                }
                break;
            default:
                break;
        }
    }

    private void fire() {
        MainFrame.me.objs.add(new Bullet(this.x , this.y, this.dir, ObjType.BULLET, this));
    }

    private void fire(ObjType type) {
        MainFrame.me.objs.add(new Bullet(this.x , this.y, this.dir, type, this));
    }

    private void switchDir() {
        moving = Dl || Dr || Du || Dd;

        if (Dl && !Dr && !Du && !Dd) {
            dir = Direction.Left;
        }

        if (!Dl && Dr && !Du && !Dd) {
            dir = Direction.Right;
        }

        if (!Dl && !Dr && Du && !Dd) {
            dir = Direction.Up;
        }

        if (!Dl && !Dr && !Du && Dd) {
            dir = Direction.Down;
        }
    }

    private void clearDir() {
        Dl = false;
        Dr = false;
        Du = false;
        Dd = false;
    }

    /**
     * 判断是否越界
     */
    public synchronized void move() {
        int oldX = x;
        int oldY = y;
        switch (dir) {
            case Left:
                x -= this.type.getStep();
                if (x < width / 2) x = width / 2;
                if (hasObstacle()) x = oldX;
                break;
            case Right:
                x += this.type.getStep();
                if (x > MainFrame.me.sizeX - width / 2) x = MainFrame.me.sizeX - width / 2;
                if (hasObstacle()) x = oldX;
                break;
            case Up:
                y -= this.type.getStep();
                if (y < height) y = height;
                if (hasObstacle()) y = oldY;
                break;
            case Down:
                y += this.type.getStep();
                if (y > MainFrame.me.sizeY - height / 2) y = MainFrame.me.sizeY - height / 2;
                if (hasObstacle()) y = oldY;
                break;
            default:
                break;
        }
        // 敌方tank 随机给定方向
        if (ObjType.getEnemyUnit().contains(type)) {
            if (RandomUtil.getRandom()) dir = Direction.getRandomDir();
            if (RandomUtil.getRandom()) fire(ObjType.ENEMYBULLET);
        }
    }

    /**
     * 是否有障碍物
     */
    private boolean hasObstacle() {
        return MainFrame.me.objs.parallelStream().filter(e -> !equals(e) && (e instanceof BaseEnemy)).anyMatch(e -> e.getType().isObstacle() && getRectangle().intersects(e.getRectangle()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tank tank = (Tank) o;
        return Dl == tank.Dl &&
                Dr == tank.Dr &&
                Du == tank.Du &&
                Dd == tank.Dd &&
                Objects.equals(bullet, tank.bullet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Dl, Dr, Du, Dd, bullet);
    }
}
