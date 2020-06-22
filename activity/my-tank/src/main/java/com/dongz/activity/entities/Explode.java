package com.dongz.activity.entities;

import com.dongz.activity.enums.ObjType;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auth dz
 * @time 2020/6/22 15:02
 * @desc 爆炸
 */
@Data
public class Explode extends BaseEntity {
    private static List<BufferedImage> images = new ArrayList<>();
    private int index = 0;

    static {
        for (int i = 1; i < 10; i++) {
            try {
                BufferedImage img = ImageIO.read(Explode.class.getClassLoader().getResourceAsStream(String.format(ObjType.EXPLODE.getImg(), i)));
                images.add(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        this.isLive = true;
        this.type = ObjType.EXPLODE;
    }

    public void paint(Graphics g) {
        if (index < images.size()) {
            BufferedImage image = images.get(index);
            g.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
            index++;
        } else {
            isLive = false;
        }
    }
}
