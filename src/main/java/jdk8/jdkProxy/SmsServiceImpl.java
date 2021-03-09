package jdk8.jdkProxy;

/**
 * description: SmsServiceImpl <br>
 * date: 2021/3/5 下午3:00 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public void sendSms(String sms) {
        System.out.println("发送短信。。。" + sms);
    }

    @Override
    public void sendImage() {
        System.out.println("发送彩信。。。彩色的啊");
    }
}
