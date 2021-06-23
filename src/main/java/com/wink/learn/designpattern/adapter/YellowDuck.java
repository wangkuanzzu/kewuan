package com.wink.learn.designpattern.adapter;

/**
 * description: YellowDuck <br>
 * date: 2021/6/3 下午3:29 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class YellowDuck implements Duck {

    @Override
    public void quark() {
        System.out.println("=== 呱呱 ===");
    }

    @Override
    public void fly() {
        System.out.println("=== 飞了十米 ===");
    }
}
