import io.nats.client.*;
import manhua.YiRenZhiXia;
import org.joda.time.DateTime;
import utils.DateUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Test {

    public static int count = 0;

    public static void main(String[] args) {

        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }


//            System.out.println("-------------------");
//
//            YiRenZhiXia xia = new YiRenZhiXia("冯宝宝");
//
//            YiRenZhiXia zhiXia = new YiRenZhiXia("张楚岚");

//        String a = "abcdc";
//        System.out.println(longestPalindrome(a));

//        List<Student> students = new ArrayList<>();
//        students.add(new Student("张三", "男"));
//        students.add(new Student("李四", "男"));
//        students.add(new Student("小红", "女"));
//        students.add(new Student("小花", "女"));
//        students.add(new Student("小红", "女"));

        //统计男生个数
        //stream 流遍历
//        long count = students.stream()
//                .filter(Student::isBoy) // 等同于.filter(student -> student.isBoy())
//                .count();
//
//        System.out.println("男生个数 = " + count);



//        ArrayList<String> stringList  = new ArrayList<>();
//        System.out.println(stringList.size());
//        stringList.add("a");
//        System.out.println(stringList.toString());
//
//        LinkedList<String> stringList1 = new LinkedList<>();
//        stringList1.add("b");
//        stringList1.add("c");
//        System.out.println(stringList1.toString());

//        Object a = 1;
//        Object b = a.toString();
//        System.out.println(a instanceof Number);
//        System.out.println(b instanceof Number);
//
//        System.out.println(new BigDecimal(String.valueOf(0)));

//        System.out.println(Math.abs(13 % 1));
//        System.out.println(Math.abs(13 % 2));
//        System.out.println(Math.abs(13 % 3));
//        System.out.println(Math.abs(13 % 4));
//        System.out.println(Math.abs(13 % 5));

//        System.out.println(Math.abs(1 & 6));
//        System.out.println(Math.abs(2 & 6));
//        System.out.println(Math.abs(3 & 6));



//        Integer i = 1;
//        switch (i){
//            case 1:
//                System.out.println(i);
//                break;
//            case 2:
//                System.out.println(i);
//                break;
//            default:
//                System.out.println("------");
//
//        }


//        String app = "1,2,3,4";
//        System.out.println(app.split(",").length);

//        String s = "wink";
//        String s2 = String.format("%s/",s);
//        System.out.println(s2);

//        System.out.println(DateTime.now());
//        System.out.println(DateTime.now().hourOfDay());
//        System.out.println(DateTime.now().hourOfDay().roundFloorCopy());
//        System.out.println(DateTime.now().hourOfDay().roundFloorCopy().toDate());
//        Set<Long> set1 = new HashSet<Long>(){
//            {
//                add(1L);
//                add(2L);
//                add(3L);
//                add(4L);
//            }
//        };
//        Set<Long> set2 = new HashSet<Long>(){
//            {
//                add(3L);
//                add(4L);
//                add(5L);
//                add(6L);
//            }
//        };
//
//        Set<Long> result = new HashSet<>();
//
//        result.clear();
//        result.addAll(set1);
//        result.retainAll(set2);
//        System.out.println("交集：" + result);
//
//        result.clear();
//        result.addAll(set1);
//        result.removeAll(set2);
//        System.out.println("差集：" + result);
//
//        result.clear();
//        result.addAll(set2);
//        result.removeAll(set1);
//        System.out.println("差集：" + result);
//
//        result.clear();
//        result.addAll(set1);
//        result.addAll(set2);
//        System.out.println("并集：" + result);



//        String mobile = " 1851134226 4 ";
//        System.out.println(mobile);
////        String pwd = mobile.substring(mobile.length()-6);
//        System.out.println(mobile.trim());

//        String msg = "日落西山红霞飞【死歌】";
//        String nmsg = rewriteContent(msg);
//        System.out.println(nmsg);
//        int i = calcSmsNum(nmsg,"【死歌2】");
//        System.out.println(nmsg);

//        for(int i=0; i< 1000; i++){
//            new Thread(TempTest::incr).start();
//        }
//        Thread.sleep(5000);
//        System.out.println("运行结果："+count);

//        String str_date = "2020-02-05 16:23:08.0";
//        String res_date = DateUtil.dateFormatTOYYYYMMDD(str_date,DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS);
//        System.out.println(res_date);
//        List<String> list = new ArrayList<>();
//        list.add("aaa");
//        System.out.println(list.size() == 0);
//
//        // 链接本地nats
//        Connection nc = Nats.connect("nats://127.0.0.1:4222");

//        // 链接服务nats
//        Connection ncServer = Nats.connect("nats://myhost:4222");
//
//        // Connect to one or more servers with a custom configuration
//        Options o = new Options.Builder().server("nats://serverone:4222").server("nats://servertwo:4222").maxReconnects(-1).build();
//        Connection ncMore = Nats.connect(o);


        // 发布消息
//        nc.publish("subject", "hello world".getBytes(StandardCharsets.UTF_8));

//        nc.publish("subject", "replyto", "hello world".getBytes(StandardCharsets.UTF_8));


        // 订阅消息
//        Subscription sub = nc.subscribe("subject");
//        Message msg1 = sub.nextMessage(Duration.ofMillis(500));
//        String response1 = new String(msg1.getData(),StandardCharsets.UTF_8);
//        System.out.println("response ==> " + response1);

//        // 订阅消息后
//        Dispatcher d = nc.createDispatcher((msg2) -> {
//            String response2 = new String(msg2.getData(), StandardCharsets.UTF_8);
//            // todo 处理消息
//        });
//        d.subscribe("subject");
//
//
//        // 订阅消息 消息处理满足100次后取消订阅
//        Dispatcher d2 = nc.createDispatcher((msg) -> {});
//
//        Subscription s = d2.subscribe("some.subject", (msg3) -> {
//            String response3 = new String(msg3.getData(), StandardCharsets.UTF_8);
//            System.out.println("Message received (up to 100 times): " + response3);
//        });
//        d2.unsubscribe(s, 100);



    }

    static class Student{
        private String name;
        private String sex;

        public Student(String name, String sex){
            this.name = name;
            this.sex = sex;
        }

        public Boolean isBoy(){
            return "男".equals(this.sex);
        }
        public String hasName(){
            return this.name;
        }
    }



    public static void incr(){
        count++;
    }

    public static boolean isNumber(String str){
        String reg = "^[1-9][0-9]{0,}$";
        return str.matches(reg);
    }


    public void readLog(){
        String fileName = "/Users/kuan/temp/data/result51.log";
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                System.out.println(tempString.substring(tempString.indexOf("REQUEST_URL: ")+13,tempString.indexOf(", client:")));

                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 计算短信长度,加上短信签名， 大于70按照67个字符每条发送
     *
     * @param smsContent
     * @return
     */
    public static int calcSmsNum(String smsContent, String sign) {
        smsContent = new StringBuilder(smsContent).append("【").append(sign).append("】").toString();
        int len = smsContent.length();
        if (len <= 70) return 1;
        int tmp = len % 67;
        if (tmp == 0) return len / 67;
        return len / 67 + 1;
    }

    /**
     * 重新设定短信内容, 去掉原有设定签名
     *
     * @param content
     * @return
     */
    public static String rewriteContent(String content) {
        String tmp = content;
        int p1 = tmp.indexOf("【");
        int p2 = tmp.indexOf("】");

        if (p1 != -1 && p2 != -1) {
            String s1 = tmp.substring(0, p1);
            String s2 = tmp.substring(p2 + 1);
            tmp = new StringBuilder(s1).append(s2).toString();
        }
        return new StringBuilder(tmp).toString();

    }
}
