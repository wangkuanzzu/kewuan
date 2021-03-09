package jdk8.jdkProxy;

/**
 * description: TestProxy <br>
 * date: 2021/3/5 下午3:11 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class TestProxy {

    //jdk的动态代理原理
    //你通过Proxy 类的 newProxyInstance() 创建的代理对象在调用方法的时候，实际会调用到实现InvocationHandler 接口的类的 invoke()方法。
    public static void main(String[] args) {
        SmsService smsService = (SmsService) ProxyFactory.getProxy(new SmsServiceImpl());
        smsService.sendSms("智商盆地");
        smsService.sendImage();
    }
}
