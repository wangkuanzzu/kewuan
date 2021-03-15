package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * description: LeetCode13 <br>
 * date: 2021/3/15 下午4:45 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
            map.put("M",1000);
            map.put("CM",900);
            map.put("D",500);
            map.put("CD",400);
            map.put("C",100);
            map.put("XC",90);
            map.put("L",50);
            map.put("XL",40);
            map.put("X",10);
            map.put("IX",9);
            map.put("V",5);
            map.put("IV",4);
            map.put("I",1);

        int result = 0;
        String[] strings = s.split("");
        for (int i = 0; i < strings.length; i++) {
            if(i+1 < strings.length && map.containsKey(strings[i]+strings[i+1])){
                result += map.get(strings[i]+strings[i+1]);
                i++;
            }else{
                result += map.get(strings[i]);
            }
        }
        return result;

    }
}
