package com.wink.learn.jdk8.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description: DefaultInvacationHandler <br>
 * date: 2021/3/5 下午3:01 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DefaultInvocationHandler implements InvocationHandler {

    private final Object target;

    public DefaultInvocationHandler(Object object) {
        this.target = object;
    }

    /**
     *         proxy :动态生成的代理类
     *         method : 与代理类对象调用的方法相对应
     *         args : 当前 method 方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //目标对象方法执行前
        System.out.println("发送短信前。。。" + method.getName());
        //执行目标对象方法
        Object result = method.invoke(this.target,args);
        //目标对象方法执行后
        System.out.println("发送短信后。。。" + method.getName());
        return result;
    }
}
