package com.dongz.activity.obj;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;

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
public abstract class BaseObj {
    // 位置
    int x,y;
    // 方向
    Direction dir;
    // 是否静止
    boolean moving;
    // 分组
    Group group;
    // 图片
    Map<String, BufferedImage> imgPo = new HashMap<>();

    private BufferedImage getPoImg(Direction dir) throws IOException {
        if (imgPo.containsKey(dir.name())) {
            return imgPo.get(dir.name());
        }

        BufferedImage img = ImageIO.read(Tank.class.getClassLoader().getResourceAsStream(String.format(this.group.getImg(), dir.getFix())));
        imgPo.put(dir.name(), img);
        return img;
    }

    public void paint(Graphics g) {
        try {
            BufferedImage bi = getPoImg(dir);
            g.drawImage(bi, x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (moving) {
            move();
        }
    }

    private void move() {
        switch (dir) {
            case Left:
                x -= this.group.getStep();
                break;
            case Right:
                x += this.group.getStep();
                break;
            case Up:
                y -= this.group.getStep();
                break;
            case Down:
                y += this.group.getStep();
                break;
            default:
                break;
        }
    }
}
