package designpattern.decorate.mydecorate;

import jdk.nashorn.internal.ir.CallNode;

/**
 * description: TestMain <br>
 * date: 2021/5/28 上午11:43 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {
        BanMian banMian = new BanMian();

        JiDanBanMian jiDanBanMian = new JiDanBanMian(banMian);

        KaoChangBanMian kaoChangBanMian = new KaoChangBanMian(jiDanBanMian);

        System.out.println("kaoChangBanMian = " + kaoChangBanMian.getDescription());
        System.out.println("kaoChangBanMian = " + kaoChangBanMian.price());
    }
}
