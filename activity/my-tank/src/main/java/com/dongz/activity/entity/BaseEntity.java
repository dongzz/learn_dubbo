package com.dongz.activity.entity;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.ObjType;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auth dz
 * @time 2020/6/18 1:11
 * @desc
 */
@Data
public abstract class BaseEntity {
    // 生命值
    int life;
    // 是否存活
    boolean isLive;
    // 位置
    int x,y;
    int width,height;
    // 方向
    Direction dir;
    // 是否静止
    boolean moving;
    // 分组
    ObjType type;
    // 图片
    Map<String, BufferedImage> imgPo = new HashMap<>();
    // 形状
    Rectangle rectangle;

    public BaseEntity(int x, int y, Direction dir, ObjType type) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.type = type;
        // 是否是玩家
        this.moving = !ObjType.getP().contains(type);
        this.isLive = true;
        this.life = type.getLife();
    }

    public BufferedImage getPoImg(Direction dir) throws IOException {
        if (imgPo.containsKey(dir.name())) {
            return imgPo.get(dir.name());
        }

        BufferedImage img = ImageIO.read(Tank.class.getClassLoader().getResourceAsStream(String.format(this.type.getImg(), dir.getFix())));
        imgPo.put(dir.name(), img);
        width = img.getWidth();
        height = img.getHeight();
        return img;
    }

    public Rectangle getRectangle() {
        return rectangle = new Rectangle(x - width / 2, y - height / 2, width, height);
    }

    public void paint(Graphics g) {
        try {
            BufferedImage bi = getPoImg(dir);
            g.drawImage(bi, x - width / 2, y - height / 2, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (moving) {
            move();
        }
    }

    public abstract void move();
}
