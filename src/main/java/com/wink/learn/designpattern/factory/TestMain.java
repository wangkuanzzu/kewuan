package com.wink.learn.designpattern.factory;

import com.wink.learn.designpattern.factory.simple.APizzaStore;
import com.wink.learn.designpattern.factory.simple.BPizzaStore;

/**
 * description: TestMain <br>
 * date: 2021/5/31 下午6:24 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {
        APizzaStore aPizzaStore = new APizzaStore();
        Pizza pizza1 = aPizzaStore.orderPizza("A1");
        System.out.println(" ====pizza1==== "+ pizza1 );

        Pizza pizza2 = aPizzaStore.orderPizza("A2");
        System.out.println(" =====pizza2=== " + pizza2 );

        Pizza pizza3 = aPizzaStore.orderPizza("A3");
        System.out.println(" =====pizza3=== " + pizza3);

        BPizzaStore bPizzaStore = new BPizzaStore();
        Pizza pizza4 = bPizzaStore.orderPizza("B1");
        System.out.println(" ======== " );
    }

}
