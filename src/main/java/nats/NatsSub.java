package nats;

import io.nats.client.*;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class NatsSub {
    public static final String subject = "test-kuan";
//    public static final String queue = "click";
    public static final String servers = "nats://127.0.0.1:4222";

    public static void main(String[] args) throws Exception {
//        subscribe2Queue1();
//        subscribe2Queue2();

//        subscribe1();

        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new MyThread(countDownLatch));
            thread.setName("线程-" + (i + 1));
            thread.start();
            countDownLatch.countDown();
        }

    }
    static class MyThread implements Runnable{

        private final CountDownLatch countDownLatch;

        public MyThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                subscribe1();
            } catch (Exception ignored){

            }
        }
    }

    public static void subscribe1() throws Exception{
        Connection nc = Nats.connect(servers);
        Dispatcher d = nc.createDispatcher((msg2) -> {
            String response2 = new String(msg2.getData(), StandardCharsets.UTF_8);
            // todo 处理消息
            System.out.println(Thread.currentThread().getName()+", get msg:" + response2);
        });
        d.subscribe(subject);
        System.out.println(Thread.currentThread().getName() +", waiting msg ......");
    }

    public static void subscribe2Queue1() throws Exception{
        Connection nc = Nats.connect(servers);
        Dispatcher d = nc.createDispatcher((msg2) -> {
            String response2 = new String(msg2.getData(), StandardCharsets.UTF_8);
            // todo 处理消息
            System.out.println("get msg Queue1:" + response2);
        });
        d.subscribe(subject,"click");
    }

    public static void subscribe2Queue2() throws Exception{
        Connection nc = Nats.connect(servers);
        Dispatcher d = nc.createDispatcher((msg2) -> {
            String response2 = new String(msg2.getData(), StandardCharsets.UTF_8);
            // todo 处理消息
            System.out.println("get msg Queue2:" + response2);
        });
        d.subscribe(subject,"click");
    }

    public static void subscribe3() throws Exception{
        Connection nc = Nats.connect(servers);
        CountDownLatch latch = new CountDownLatch(10); // 订阅10条消息后取消订阅
        Dispatcher d = nc.createDispatcher((msg2) -> {
            String response2 = new String(msg2.getData(), StandardCharsets.UTF_8);
            // todo 处理消息
            System.out.println("get msg:" + response2);
            System.out.println("get msg reply:" + msg2.getReplyTo());
            nc.publish(msg2.getReplyTo(), msg2.getData());
            latch.countDown();
        });
        d.subscribe(subject);
        nc.flush(Duration.ofSeconds(5));

        latch.await();

        nc.closeDispatcher(d); // This isn't required, closing the connection will do it
        nc.close();
    }
}
