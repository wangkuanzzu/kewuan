package com.wink.learn.jdk8.cglibProxy;

/**
 * description: KuanSmsService <br>
 * date: 2021/3/5 下午5:37 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MySmsService {

    public String sendSms(String msg){
        System.out.println("我的短信发送。。。" + msg);
        return msg;
    }
}
