package com.wink.learn.designpattern.decorate.mydecorate;

/**
 * description: KuanMian <br>
 * date: 2021/5/27 上午11:40 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class BanMian extends Noodles {
    @Override
    public String getDescription() {
        return "老板来一份板面。";
    }

    @Override
    public double price() {
        return 16.00;
    }
}
