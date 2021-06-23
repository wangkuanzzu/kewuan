package com.wink.learn.designpattern.single;

/**
 * description: SingleObject <br>
 * date: 2021/6/2 下午2:30 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class SingleObject {
    //构造函数私有
    private SingleObject(){}

    //创建一个静态变量持有本实例对象
    private volatile static SingleObject instance = null;

    //提供一个静态方法获取实例对象
    public static SingleObject getInstance(){
        if(instance == null){
            synchronized (SingleObject.class){
                if(instance == null){
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }

    public void showMessage(){
        System.out.println(" ==== singleObject ==== ");
    }

}
