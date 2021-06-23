package com.wink.learn.jdk8.thread.pool;

/**
 * description: MyRunnable <br>
 * date: 2021/3/8 下午6:09 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MyThread extends Thread {

    private String myCode;

    public MyThread(String myCode) {
        this.myCode = myCode;
    }

    @Override
    public void run() {
        System.out.println("start time " + System.currentTimeMillis());

        System.out.println("我的代码  " + myCode);

        processCommand();

        System.out.println("end time " + System.currentTimeMillis());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
