package com.wink.learn.designpattern.decorate.mydecorate;

/**
 * description: JiDanBanMian <br>
 * date: 2021/5/28 上午11:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class KaoChangBanMian extends NoodlesDecorate {

    private Noodles noodles;

    public KaoChangBanMian(Noodles noodles) {
        this.noodles = noodles;
    }

    @Override
    public String getDescription() {
        return noodles.getDescription() + "加一个烤肠。";
    }

    @Override
    public double price() {
        return noodles.price() + 3.00;
    }
}
