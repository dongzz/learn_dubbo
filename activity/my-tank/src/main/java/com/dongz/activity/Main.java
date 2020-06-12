package com.dongz.activity;

import com.dongz.activity.frame.TankFrame;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Frame f = new TankFrame();
        f.setVisible(true);

        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            f.repaint();
        }
    }
}
