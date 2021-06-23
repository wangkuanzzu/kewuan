package com.wink.learn.designpattern.factory.abstractt.Ingredient;

/**
 * description: CheeseA <br>
 * date: 2021/6/1 下午1:39 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class CheeseA implements Cheese{
    public String name;

    public CheeseA() {
    }

    public CheeseA(String name) {
        this.name = name;
    }
}
