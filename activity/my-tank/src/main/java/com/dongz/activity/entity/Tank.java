package com.dongz.activity.entity;

import com.dongz.activity.emnu.Direction;
import lombok.Data;

import java.awt.*;
import java.awt.event.KeyEvent;

@Data
public class Tank {
    // 坦克的位置
    private int x,y;
    private boolean Dl,Dr,Du,Dd;
    private static final int STEP = 5;

    // 坦克的方向
    private Direction po;
    // 是否静止
    private boolean moving;

    public Tank(int x, int y, Direction po, boolean moving) {
        this.x = x;
        this.y = y;
        this.po = po;
        this.moving = moving;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        if (moving) {
            move();
        }
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
            default:
                break;
        }
    }

    private void switchDir() {
        moving = Dl || Dr || Du || Dd;

        if (Dl && !Dr && !Du && !Dd) {
            po = Direction.Left;
        }

        if (!Dl && Dr && !Du && !Dd) {
            po = Direction.Right;
        }

        if (!Dl && !Dr && Du && !Dd) {
            po = Direction.Up;
        }

        if (!Dl && !Dr && !Du && Dd) {
            po = Direction.Down;
        }
    }

    private void move() {
        switch (po) {
            case Left:
                x -= STEP;
                break;
            case Right:
                x += STEP;
                break;
            case Up:
                y -= STEP;
                break;
            case Down:
                y += STEP;
                break;
            default:
                break;
        }
    }

    private void clearDir() {
        Dl = false;
        Dr = false;
        Du = false;
        Dd = false;
    }
}
