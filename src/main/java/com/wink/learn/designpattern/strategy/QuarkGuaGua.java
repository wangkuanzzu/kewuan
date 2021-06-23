package com.wink.learn.designpattern.strategy;

/**
 * description: QuarkGuaGua <br>
 * date: 2021/5/26 上午9:54 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class QuarkGuaGua implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("gua gua gua gua");
    }
}
