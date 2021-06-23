package com.wink.learn.designpattern.observer.jdk;

/**
 * description: TestMain <br>
 * date: 2021/5/27 上午9:54 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestMain {

    public static void main(String[] args) {
        Subject subject = new Subject();
        //通过调用构造函数完成观察者注册功能
        Observer1 observer1 = new Observer1(subject);

        System.out.println("=====30====");
        subject.setState(30);
    }
}
