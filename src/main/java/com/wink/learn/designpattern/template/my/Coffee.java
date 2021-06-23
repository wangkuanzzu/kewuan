package com.wink.learn.designpattern.template.my;

/**
 * description: Caffee <br>
 * date: 2021/6/7 上午10:33 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println(" =打开一包咖啡= ");
    }

    @Override
    void addCondiments() {
        System.out.println(" =添加牛奶、白砂糖，变得甜一点= ");
    }
}
