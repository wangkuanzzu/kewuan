package com.wink.learn.spi.jdk;

import com.wink.learn.spi.jdk.Robot;

/**
 * description: Bumblebee <br>
 * date: 2020/8/28 4:07 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee Prime.");
    }
}
