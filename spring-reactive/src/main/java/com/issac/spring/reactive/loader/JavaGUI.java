package com.issac.spring.reactive.loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * author:  ywy
 * date:    2019-01-13
 * desc:
 */
public class JavaGUI {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("GUI示例");
        jFrame.setBounds(500,300,400,300);
        LayoutManager layoutManager = new BorderLayout(400,300);
        jFrame.setLayout(layoutManager);
        jFrame.addMouseListener(new MouseAdapter() { // callback 1
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.printf("[线程：%s]鼠标点击，坐标（X: %d,Y %d）\n",
                        Thread.currentThread().getName(),e.getX(),e.getY());
            }
        });
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.printf("[线程：%s]清除 jFrame...\n", // callback 2
                        Thread.currentThread().getName());
                jFrame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.printf("[线程：%s]退出程序 ...\n",
                        Thread.currentThread().getName());
                System.exit(0);
            }
        });
        System.out.println("当前线程：" + Thread.currentThread().getName());
        jFrame.setVisible(true);
    }
}
