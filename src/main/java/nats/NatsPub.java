package nats;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.*;

public class NatsPub {
    public static final String subject = "bigdata-adpstion-cnt";
    public static final String servers = "nats://172.17.15.62:4222";

    public static void main(String[] args) throws Exception {
        publish0();
//        publish2();
    }

    public static void publish0() throws Exception {
        Connection nc = Nats.connect(servers);
        // 消息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = scanner.nextLine();
            // 发布消息
            nc.publish(subject,line.getBytes(StandardCharsets.UTF_8));
        }
    }

    public static void publish1() throws Exception {
        Connection nc = Nats.connect(servers);
        // 消息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = scanner.nextLine();
            // 发布消息
            nc.publish(subject,"click", line.getBytes(StandardCharsets.UTF_8));
            Message msg = nc.subscribe("click").nextMessage(Duration.ofSeconds(5));
            String response = new String(msg.getData(),StandardCharsets.UTF_8);
            System.out.println("response : "+response);
        }
    }

    public static void publish2() throws Exception{
        Connection nc = Nats.connect(servers);
        // 消息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = scanner.nextLine();
            // 发布消息
            CompletableFuture<Message> replyFuture = nc.request(subject, line.getBytes(StandardCharsets.UTF_8));
            Message reply = replyFuture.get(5, TimeUnit.SECONDS);
            System.out.println();
            System.out.printf("Received reply \"%s\" on subject \"%s\"\n",
                    new String(reply.getData(), StandardCharsets.UTF_8),
                    reply.getSubject());
            System.out.println();
        }
    }

}
