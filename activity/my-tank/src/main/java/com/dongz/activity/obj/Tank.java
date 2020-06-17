package com.dongz.activity.obj;

import com.dongz.activity.emnu.Direction;
import com.dongz.activity.emnu.Group;
import lombok.Data;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

@Data
public class Tank extends BaseObj {
    private boolean Dl, Dr, Du, Dd;

    public Tank(int x, int y, Direction dir, boolean moving, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = moving;
        this.group = group;
    }

    public void keyPressed(KeyEvent e) {
        clearDir();
        switchPo(e, true);
        switchDir();
    }

    public void keyReleased(KeyEvent e) {
        switchPo(e, false);
        switchDir();
    }

    private void switchPo(KeyEvent e, boolean move) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                Dl = move;
                break;
            case KeyEvent.VK_RIGHT:
                Dr = move;
                break;
            case KeyEvent.VK_UP:
                Du = move;
                break;
            case KeyEvent.VK_DOWN:
                Dd = move;
                break;
            default:
                break;
        }
    }

    private void switchDir() {
        moving = Dl || Dr || Du || Dd;

        if (Dl && !Dr && !Du && !Dd) {
            dir = Direction.Left;
        }

        if (!Dl && Dr && !Du && !Dd) {
            dir = Direction.Right;
        }

        if (!Dl && !Dr && Du && !Dd) {
            dir = Direction.Up;
        }

        if (!Dl && !Dr && !Du && Dd) {
            dir = Direction.Down;
        }
    }

    private void clearDir() {
        Dl = false;
        Dr = false;
        Du = false;
        Dd = false;
    }

    // 旋转图片
    private BufferedImage rotateImage(final BufferedImage img, final int degree) {
        int width = img.getWidth();
        int height = img.getHeight();
        int transparency = img.getColorModel().getTransparency();
        BufferedImage image;
        Graphics2D graphics2D;

        (graphics2D = (image = new BufferedImage(width, height, transparency)).createGraphics())
                .setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        graphics2D.rotate(Math.toRadians(degree), width / 2, height / 2);
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();
        return image;
    }
}
