package com.dongz.activity.obj;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;
import com.dongz.activity.frame.TankFrame;
import lombok.Data;

import java.awt.event.KeyEvent;

@Data
public class Tank extends BaseObj {
    private boolean Dl, Dr, Du, Dd;

    private Bullet bullet;

    public Tank(int x, int y, Direction dir, boolean moving, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isLive = true;
        this.moving = moving;
        this.group = group;
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
        TankFrame.me.bullets.add(new Bullet(this.x , this.y, this.dir, Group.BULLET));
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

    public void move() {
        switch (dir) {
            case Left:
                x -= this.group.getStep();
                if (x < width / 2) x = width / 2;
                break;
            case Right:
                x += this.group.getStep();
                if (x > TankFrame.me.sizeX - width / 2) x = TankFrame.me.sizeX - width / 2;
                break;
            case Up:
                y -= this.group.getStep();
                if (y < height / 2) y = height / 2;
                break;
            case Down:
                y += this.group.getStep();
                if (y > TankFrame.me.sizeY - height / 2) y = TankFrame.me.sizeY - height / 2;
                break;
            default:
                break;
        }
    }
}
