package com.wink.learn.nats;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NatsReq {

    public static void main(String[] args) throws Exception {
        Connection nc = Nats.connect();
        String message = "i am a message";
        Future<Message> replyFuture = nc.request("ad", message.getBytes(StandardCharsets.UTF_8));
        Message reply = replyFuture.get(5, TimeUnit.SECONDS);

        System.out.println();
        System.out.printf("Received reply \"%s\" on subject \"%s\"\n",
                new String(reply.getData(), StandardCharsets.UTF_8),
                reply.getSubject());
        System.out.println();

        nc.close();
    }
}
