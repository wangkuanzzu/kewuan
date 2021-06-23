package com.wink.learn.designpattern.decorate.mydecorate;

/**
 * description: BanMian <br>
 * date: 2021/5/27 上午10:32 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public abstract class Noodles {
    //面条描述
    private String description;
    public String getDescription() {
        return description;
    }
    //面条价钱
    public abstract double price();
}
