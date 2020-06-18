package com.dongz.activity.frame;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.entity.BaseEntity;
import com.dongz.activity.entity.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TankFrame extends Frame {
    // 单例
    public final static TankFrame me = new TankFrame();

    public final static int sizeX = 800, sizeY = 600;
    public List<BaseEntity> objs = new ArrayList<>();

    Image offImg;

    private TankFrame() {
        this.setLocation(400, 100);
        this.setSize(sizeX, sizeY);
        this.setTitle("tank war");
        // 我方tank
        objs.add(new Tank(100, 100, Direction.Up, true, com.dongz.activity.emnu.Type.P1));
        // 敌方tank
        objs.add(new Tank(200, 200, Direction.Up, true, com.dongz.activity.emnu.Type.ENEMY2));
        objs.add(new Tank(300, 200, Direction.Up, true, com.dongz.activity.emnu.Type.ENEMY4));
        objs.add(new Tank(200, 300, Direction.Up, true, com.dongz.activity.emnu.Type.ENEMY5));
        //增加键盘监听事件
        this.addKeyListener(new TankKeyLister());
    }

    @Override
    public void paint(Graphics g) {
        List<BaseEntity> collect = me.objs.parallelStream().filter(BaseEntity::isLive).collect(Collectors.toList());
        collect.forEach(e -> e.paint(g));
        me.objs.removeIf(e -> !e.isLive());

        // 显示地方tank数量
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("enemies: " + me.objs.parallelStream().filter(item -> item.isLive() && com.dongz.activity.emnu.Type.getEnemyTank().contains(item.getType())).count(), 10, 50);
        g.setColor(c);
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
            List<BaseEntity> tanks = me.objs.parallelStream().filter(item -> (item instanceof Tank) && item.isLive() && com.dongz.activity.emnu.Type.getP().contains(item.getType())).collect(Collectors.toList());
            tanks.forEach(item -> ((Tank) item).keyPressed(e));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            List<BaseEntity> tanks = me.objs.parallelStream().filter(item -> (item instanceof Tank) && item.isLive() && com.dongz.activity.emnu.Type.getP().contains(item.getType())).collect(Collectors.toList());
            tanks.forEach(item -> ((Tank) item).keyReleased(e));
        }
    }
}
