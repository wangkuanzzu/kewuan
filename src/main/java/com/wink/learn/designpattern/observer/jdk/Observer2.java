package com.wink.learn.designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * description: Observer1 <br>
 * date: 2021/5/27 上午9:50 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Observer2 implements Observer {
    Observable observable;
    public Observer2(Observable observable) {
        this.observable=observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Subject s = (Subject) o;
        System.out.println("2 s.getState() = " + s.getState());
        System.out.println("2 receive state is " + arg);
    }
}
