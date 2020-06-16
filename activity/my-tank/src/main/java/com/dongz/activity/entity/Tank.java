package com.dongz.activity.entity;

import com.dongz.activity.emnu.Direction;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class Tank {
    // 坦克的位置
    private int x,y;
    private boolean Dl,Dr,Du,Dd;
    private static final int STEP = 5;
    private Map<String, BufferedImage> imgPo = new HashMap<>();

    // 坦克的方向
    private Direction po;
    // 是否静止
    private boolean moving;

    // 图片
    private String imgName;

    public Tank(int x, int y, Direction po, String imgName, boolean moving) {
        this.x = x;
        this.y = y;
        this.po = po;
        this.imgName = imgName;
        this.moving = moving;
    }

    private BufferedImage getPoImg(Direction po) throws IOException {
        if (imgPo.containsKey(po.name())) {
            return imgPo.get(po.name());
        }

        BufferedImage img = ImageIO.read(Tank.class.getClassLoader().getResourceAsStream(po.getFix().replace("{name}", imgName)));
        imgPo.put(po.name(), img);
        return img;
    }

    public void paint(Graphics g) {
        try {
            BufferedImage bi = getPoImg(po);
            g.drawImage(bi, x, y, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (moving) {
            move();
        }
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
            po = Direction.Left;
        }

        if (!Dl && Dr && !Du && !Dd) {
            po = Direction.Right;
        }

        if (!Dl && !Dr && Du && !Dd) {
            po = Direction.Up;
        }

        if (!Dl && !Dr && !Du && Dd) {
            po = Direction.Down;
        }
    }

    private void move() {
        switch (po) {
            case Left:
                x -= STEP;
                break;
            case Right:
                x += STEP;
                break;
            case Up:
                y -= STEP;
                break;
            case Down:
                y += STEP;
                break;
            default:
                break;
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
