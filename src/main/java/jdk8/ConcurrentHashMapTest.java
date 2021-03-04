package jdk8;

import java.util.concurrent.ConcurrentHashMap;

/**
 * description: ConcurrentHashMapTest <br>
 * date: 2021/2/4 下午4:30 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        // 键不能重复，值可以重复
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");// 老王被覆盖
        map.put("lao", "老王");
        System.out.println("-------直接输出ConcurrentHashMap:-------");
        System.out.println(map);
    }

}
