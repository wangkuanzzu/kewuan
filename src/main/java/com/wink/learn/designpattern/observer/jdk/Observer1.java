package com.wink.learn.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * description: Observer1 <br>
 * date: 2021/5/27 上午9:50 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Observer1 implements Observer {
    Observable observable;
    public Observer1(Observable observable) {
        this.observable=observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Subject s = (Subject) o;
        //两种获取方式 被观察者对外暴露的方法
        System.out.println("1 s.getState() = " + s.getState());
        //通过参数的方式传递
        System.out.println("1 receive state is " + arg);
    }
}
