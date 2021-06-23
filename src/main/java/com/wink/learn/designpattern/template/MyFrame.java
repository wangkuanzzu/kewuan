package com.wink.learn.designpattern.template;

import javax.swing.*;
import java.awt.*;

/**
 * description: MyFrame <br>
 * date: 2021/6/8 下午3:57 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyFrame extends JFrame {

    public MyFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        String msg = "Hello World";
        g.drawString(msg, 100,150);
    }

    /**
     * JFrame中模版方法中钩子方法最多 例如paint
     * @param args
     */
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("my world");
    }
}
