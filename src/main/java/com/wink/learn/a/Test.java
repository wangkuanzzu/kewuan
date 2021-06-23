package com.wink.learn.a;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {


//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
//
//        System.out.println("context 启动成功");
//
//        MessageService messageService = (MessageService)context.getBean("messageService2");
//        System.out.println(messageService.getMessage());
//
//        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
//        MessageService messageService2 = context.getBean(MessageService.class);
//        // 这句将输出: hello world
//        System.out.println(messageService2.getMessage());
//        //方式1
////        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext();
////        applicationContext.register(User.class);
//
//        //xml配置文件
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//
//        applicationContext.refresh();
//
//        System.out.println(applicationContext.getBean("user0", User.class));
//        System.out.println(applicationContext.getBean("user0", User.class));
//        System.out.println(applicationContext.getBean("user1", User.class));
//        System.out.println(applicationContext.getBean("user1", User.class));


//        Node head = new Node(new ArrayList<>(),null);
//        Node listNode = head;
//        for (int i = 0; i < 7; i++) {
//            listNode.next = new Node(new ArrayList<>(),null);
//            listNode = listNode.next;
//            if(i==6){
//                listNode.next = head;
//            }
//        }
//        for (int i = 0; i < 7; i++) {
//            System.out.println(head.data);
//            head = head.next;
//        }
//
//        System.out.println("====================");
//
//        List<Integer> origin = new ArrayList<Integer>(){{
//            for (int i = 0; i < 18; i++) {
//                add(i);
//            }
//        }};
//
//        for (Integer integer : origin) {
//            head.data.add(integer);
//            head = head.next;
//        }
//
//        for (int i = 0; i < 8; i++) {
//            System.out.println(head.data);
//            head = head.next;
//        }




//
//            int a=3;
//            int b=3;
//            System.out.println(a-- > 3);
//            System.out.println(--b > 3);


//        double a = Double.parseDouble("1.00");
//        double b = Double.parseDouble("0.00");
//        System.out.println(Double.compare(a,b));
//        System.out.println(Double.compare(b,a));
//        System.out.println(Double.compare(a-b,a));


//        // 获取 Java 线程管理 MXBean
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
//        // 遍历线程信息，仅打印线程 ID 和线程名称信息
//        for (ThreadInfo threadInfo : threadInfos) {
//            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
//        }


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

}
