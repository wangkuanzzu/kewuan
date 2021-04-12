package jdk8.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * description: ThreadPoolExecutorDemo <br>
 * date: 2021/3/8 下午6:12 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());


        for(int i = 0; i<10; i++){
            MyRunnable worker = new MyRunnable("--" + i);

            threadPoolExecutor.execute(worker);
        }

        threadPoolExecutor.shutdown();
        while(!threadPoolExecutor.isTerminated()){}

        System.out.println("Finished all threads");
    }
}


