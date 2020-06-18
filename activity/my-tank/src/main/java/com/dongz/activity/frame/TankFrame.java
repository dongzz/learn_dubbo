package com.dongz.activity.frame;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;
import com.dongz.activity.obj.Bullet;
import com.dongz.activity.obj.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    // 单例
    public final static TankFrame me = new TankFrame();

    public final static int sizeX = 800, sizeY = 600;
    private Tank tank;
    private Tank enemy;
    public List<Bullet> bullets = new ArrayList<>();

    Image offImg;

    private TankFrame() {
        this.setLocation(400, 100);
        this.setSize(sizeX, sizeY);
        this.setTitle("tank war");
        // 我方tank
        tank = new Tank(100, 100, Direction.Up, false, Group.P1);
        // 地方tank
        enemy = new Tank(200, 200, Direction.Up, false, Group.ENEMY4);
        //增加键盘监听事件
        this.addKeyListener(new TankKeyLister());
    }

    @Override
    public void paint(Graphics g) {
        tank.paint(g);
        enemy.paint(g);
        me.bullets.parallelStream().filter(Bullet::isLive).forEach(e -> e.paint(g));
        me.bullets.removeIf(e -> !e.isLive());
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
