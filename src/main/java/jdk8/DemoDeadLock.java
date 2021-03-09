package jdk8;

/**
 * description: DemoDeadLock <br>
 * date: 2021/3/8 下午2:21 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class DemoDeadLock {

    private static  Object object1 = new Object();
    private static  Object object2 = new Object();

    public static void main(String[] args) {

        //启动两个线程
        new Thread(() -> {
            synchronized (object1){
                System.out.println(Thread.currentThread().getName() + "锁定了对象1");

            }
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("尝试获取对象2");
            synchronized (object2){
                System.out.println(Thread.currentThread().getName() + "锁定了对象2");
            }

        }, "线程1").start();


        new Thread(() -> {
            synchronized (object2){
                System.out.println(Thread.currentThread().getName() + "锁定了对象2");

            }
            try {
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("尝试获取对象1");
            synchronized (object1){
                System.out.println(Thread.currentThread().getName() + "锁定了对象1");
            }

        }, "线程2").start();

    }
}
