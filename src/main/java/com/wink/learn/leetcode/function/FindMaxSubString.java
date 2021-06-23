package com.wink.learn.leetcode.function;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:计算出给定字符串中无重复最大子串的长度
 * <p>
 * Created By kuan on 2020/1/14
 */
public class FindMaxSubString {

    public static void main(String[] args) {

        String str = "aufajsduafas";
        int n = str.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap();

        for (int i=0, j=0; j<n; j++){
            // 如果map中已经存在了该字符,设置窗口的start位置i为map中记录的下标
            if (map.containsKey(str.charAt(j))){
                i = Math.max(map.get(str.charAt(j)), i);
            }
            // 窗口的长度更新:当前的窗口宽度与历史窗口宽度的最大值
            ans = Math.max(ans, j-i+1);
            // 更新map中当前字符的下标
            map.put(str.charAt(j), j+1);
        }
        System.out.println(ans);



//        String a = "ahaha";
//        byte[] b = a.getBytes();
//        System.out.println(b.length);
//        for (byte c:b) {
//            System.out.println(c);
//        }
//
//        byte[] sb = {97,104,97,104,97};
//        String s = new String(sb);
//        System.out.println("="+s+"=");
    }
}
