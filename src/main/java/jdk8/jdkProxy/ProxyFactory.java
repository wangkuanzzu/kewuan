package jdk8.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * description: ProxyFactory <br>
 * date: 2021/3/5 下午3:08 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ProxyFactory {

    public static Object getProxy(Object target){

        /**
         * loader :类加载器，用于加载代理对象。
         * interfaces : 被代理类实现的一些接口；
         * h : 实现了 InvocationHandler 接口的对象；
         */
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DefaultInvocationHandler(target));
    }
}
