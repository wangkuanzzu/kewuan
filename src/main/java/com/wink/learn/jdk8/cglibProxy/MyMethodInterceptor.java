package com.wink.learn.jdk8.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description: MyMethodInterceptor <br>
 * date: 2021/3/5 下午5:39 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyMethodInterceptor implements MethodInterceptor {


    /**
     * obj :被代理的对象（需要增强的对象）
     * method :被拦截的方法（需要增强的方法）
     * args :方法入参
     * methodProxy :用于调用原始方法
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //调用方法之前
        System.out.println("调用方法之前" + method.getName());

        Object result = methodProxy.invokeSuper(o,objects);

        //调用方法之后
        System.out.println("调用方法之后" + method.getName());
        return result;
    }
}
