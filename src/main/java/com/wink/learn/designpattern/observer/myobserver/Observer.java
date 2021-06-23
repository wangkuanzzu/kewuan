package com.wink.learn.designpattern.observer.myobserver;

/**
 * description: Observer <br>
 * date: 2021/5/26 下午5:21 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();

}
