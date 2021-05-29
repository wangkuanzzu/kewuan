package spring;

import io.nats.client.Message;
import io.nats.client.MessageHandler;

/**
 * description: MessageServiceImpl <br>
 * date: 2021/5/11 下午5:55 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "hello world";
    }
}
