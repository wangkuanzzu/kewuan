package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description: ExampleProxy <br>
 * date: 2020/12/21 下午2:54 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ExampleProxy {

    static interface Car{
        void running();
    }

    static class Bus implements Car{

        @Override
        public void running() {
            System.out.println("bus is running......");
        }
    }

    static class Taxi implements Car{
        @Override
        public void running() {
            System.out.println("taxi is running......");
        }
    }

    static class JDKProxy implements InvocationHandler{
        private Object target;

        public Object getInstance(Object target){
            this.target = target;

            return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("动态代理之前的业务处理");
            Object result = method.invoke(target,args);
            return result;
        }
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        Car carInstance = (Car) jdkProxy.getInstance(new Bus());
        carInstance.running();
    }

}
