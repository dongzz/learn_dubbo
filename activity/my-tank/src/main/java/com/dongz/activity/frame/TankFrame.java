package com.dongz.activity.frame;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.ObjType;
import com.dongz.activity.entity.BaseEntity;
import com.dongz.activity.entity.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class TankFrame extends Frame {

    private static Random r = new Random();
    public final static int sizeX = 800, sizeY = 600;
    // 单例
    public final static TankFrame me = new TankFrame();

    public List<BaseEntity> objs = new ArrayList<>();
    Queue<Tank> enemies = new LinkedList<>();


    Image offImg;

    private TankFrame() {
        this.setLocation(400, 100);
        this.setSize(sizeX, sizeY);
        this.setTitle("tank war");
        // 我方tank
        objs.add(new Tank(100, sizeY-100, Direction.Up, ObjType.P1));
        // 敌方tank
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(sizeX);
            int y = r.nextInt(sizeY);
            enemies.add(new Tank(x, y, Direction.getRandomDir(), ObjType.getRandomEnemy()));
        }
        //增加键盘监听事件
        this.addKeyListener(new TankKeyLister());
    }

    @Override
    public void paint(Graphics g) {
        if (me.objs.size() < 5 && enemies.size() > 0) objs.add(enemies.poll());

        List<BaseEntity> collect = me.objs.parallelStream().filter(BaseEntity::isLive).collect(Collectors.toList());
        collect.forEach(e -> e.paint(g));
        me.objs.removeIf(e -> !e.isLive());

        // 显示地方tank数量
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("enemies: " + enemies.size(), 10, 50);
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
            List<BaseEntity> tanks = me.objs.parallelStream().filter(item -> (item instanceof Tank) && item.isLive() && ObjType.getP().contains(item.getType())).collect(Collectors.toList());
            tanks.forEach(item -> ((Tank) item).keyPressed(e));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            List<BaseEntity> tanks = me.objs.parallelStream().filter(item -> (item instanceof Tank) && item.isLive() && ObjType.getP().contains(item.getType())).collect(Collectors.toList());
            tanks.forEach(item -> ((Tank) item).keyReleased(e));
        }
    }
}
