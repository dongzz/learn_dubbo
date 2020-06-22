package com.dongz.activity.entities;

import com.dongz.activity.enums.Direction;
import com.dongz.activity.enums.ObjType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    // 分组
    ObjType type;
    // 形状
    Rectangle rectangle;

    public boolean isNotMe(BaseEntity entity) {
        return !this.equals(entity);
    }

    public abstract void paint(Graphics g);

    public Rectangle getRectangle() {
        return rectangle = new Rectangle(x - width / 2, y - height / 2, width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return life == that.life &&
                isLive == that.isLive &&
                x == that.x &&
                y == that.y &&
                width == that.width &&
                height == that.height &&
                type == that.type &&
                Objects.equals(rectangle, that.rectangle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(life, isLive, x, y, width, height, type, rectangle);
    }
}
