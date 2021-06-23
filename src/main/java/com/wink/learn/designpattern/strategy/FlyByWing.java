package com.wink.learn.designpattern.strategy;

/**
 * description: FlyByWing <br>
 * date: 2021/5/26 上午9:59 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class FlyByWing implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("fly - wing wing");
    }
}
