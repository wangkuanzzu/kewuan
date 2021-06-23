package com.wink.learn.designpattern.strategy;

/**
 * description: FlyBuDong <br>
 * date: 2021/5/26 上午10:06 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class FlyBuDong implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("fly - bu dong");
    }
}
