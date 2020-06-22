package com.dongz.activity.entities;

import com.dongz.activity.enums.ObjType;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auth dz
 * @time 2020/6/22 15:02
 * @desc 爆炸
 */
@Data
public class Wall extends BaseEntity {
    static Map<String, BufferedImage> walls = new HashMap<>();

    public Wall(int x, int y, ObjType type) {
        this.x = x;
        this.y = y;
        this.isLive = true;
        this.type = type;
        this.life = type.getLife();

        BufferedImage img = null;
        if (walls.containsKey(type.name())) {
            img = walls.get(type.name());
        } else {
            try {
                img = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(this.type.getImg()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            walls.put(type.name(), img);
        }
        width = img.getWidth();
        height = img.getHeight();
        getRectangle();
    }

    public void paint(Graphics g) {
        BufferedImage image = walls.getOrDefault(type.name(), null);
        if (image != null) {
            g.drawImage(image, x - image.getWidth() / 2, y - image.getHeight() / 2, null);
        }
    }
}
