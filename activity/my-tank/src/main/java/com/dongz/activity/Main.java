package com.dongz.activity;

import com.dongz.activity.frames.MainFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        MainFrame.me.setVisible(true);
        MainFrame.me.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainFrame.me.repaint();
        }
    }
}
