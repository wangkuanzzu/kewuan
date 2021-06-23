package com.wink.learn.designpattern.single;

/**
 * description: SingleTon <br>
 * date: 2021/6/2 下午2:43 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class SingleTon {

    //定一个静态内部类 持有 当前实例对象
    private static class SingleTonHolder {
        private static final SingleTon instance = new SingleTon();
    }
    //私有构造方法
    private SingleTon(){}
    //公开方法 获取实例对象
    public static SingleTon getInstance(){
        return SingleTonHolder.instance;
    }

    public void showMessage(){
        System.out.println(" ==== singleTon ==== ");
    }

}
