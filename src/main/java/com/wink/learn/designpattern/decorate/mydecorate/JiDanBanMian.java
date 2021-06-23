package com.wink.learn.designpattern.decorate.mydecorate;

/**
 * description: JiDanBanMian <br>
 * date: 2021/5/28 上午11:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class JiDanBanMian extends NoodlesDecorate {

    private Noodles noodles;

    public JiDanBanMian(Noodles noodles) {
        this.noodles = noodles;
    }

    @Override
    public String getDescription() {
        return noodles.getDescription() + "加一个鸡蛋。";
    }

    @Override
    public double price() {
        return noodles.price() + 2.00;
    }
}
