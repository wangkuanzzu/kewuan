package com.wink.learn.jdk8.cglibProxy;

/**
 * description: MyTest <br>
 * date: 2021/3/5 下午5:49 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyTest {

    public static void main(String[] args) {
        //JDK 动态代理只能只能代理实现了接口的类或者直接代理接口，而 CGLIB 可以代理未实现任何接口的类。
        MySmsService mySmsService = (MySmsService) MyCglibProxyFactory.getProxy(MySmsService.class);
        mySmsService.sendSms("大微天龙");
    }
}
