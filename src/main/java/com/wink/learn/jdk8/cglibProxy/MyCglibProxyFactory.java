package com.wink.learn.jdk8.cglibProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * description: MyCglibProxyFactory <br>
 * date: 2021/3/5 下午5:44 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyCglibProxyFactory {

    public static Object getProxy(Class<?> clazz){

        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(clazz.getClassLoader());

//        enhancer.setInterfaces(clazz.getInterfaces());

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(new MyMethodInterceptor());

        return enhancer.create();

    }
}
