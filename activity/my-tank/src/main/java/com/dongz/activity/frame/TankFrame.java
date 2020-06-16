package com.dongz.activity.frame;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.entity.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TankFrame extends Frame {
    private final int sizeX = 800, sizeY = 600;
    private Tank tank;
    private Tank enemy;

    Image offImg;

    public TankFrame() {
        this.setLocation(400, 100);
        this.setSize(sizeX, sizeY);
        this.setTitle("tank war");
        // 我方tank
        tank = new Tank(100, 100, Direction.Up, "p1tank", false);
        // 地方tank
        enemy = new Tank(200, 200, Direction.Up, "enemy0", false);
        //增加键盘监听事件
        this.addKeyListener(new TankKeyLister());
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        enemy.paint(g);
    }

    /**
     * 解决闪烁
     * 闪烁原因： 图片加载到显存过程中， 由于图片大小问题， 可能加载了一部分， 屏幕就已刷新， 此时显存中并不是完整的图片， 显示就会显示不全
     * 解决方案： 直接在内存中画好图片， 再一次性加载到显存中
     */
    @Override
    public void update(Graphics g) {
        if (offImg == null) {
            //直接在内存中创建图片
            offImg = this.createImage(sizeX, sizeY);
        }
        // 创建新的画笔（内存中）
        Graphics graphics = offImg.getGraphics();
        Color color = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, sizeX, sizeY);
        graphics.setColor(color);
        // 将tank画在内存中的图上
        paint(graphics);
        // 一次性画好图片
        g.drawImage(offImg, 0, 0, null);
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
