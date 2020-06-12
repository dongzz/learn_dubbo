package com.dongz.activity.frame;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.entity.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    private final int sizeX = 800, sizeY = 600;
    private Tank tank;
    public TankFrame() {
        this.setLocation(400, 100);
        this.setSize(sizeX, sizeY);
        this.setTitle("tank war");

        tank = new Tank(100, 100, Direction.Up, false);
        //增加键盘监听事件
        this.addKeyListener(new TankKeyLister());
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
    }

    public class TankKeyLister extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            tank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            tank.keyReleased(e);
        }
    }
}
