package com.wink.learn.designpattern.factory.abstractt.Ingredient;

/**
 * description: SauceA <br>
 * date: 2021/6/1 下午3:38 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class SauceA implements Sauce {
    public String name;

    public SauceA(String name) {
        this.name = name;
    }

    public SauceA() {
    }
}
