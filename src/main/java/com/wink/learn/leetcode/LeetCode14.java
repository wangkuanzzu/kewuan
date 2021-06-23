package com.wink.learn.leetcode;

/**
 * description: LeetCode14 <br>
 * date: 2021/3/15 下午5:31 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String[] strings = new String[]{"abc","abdcvc","abbsdc","abdccc"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String s1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(s1)){
                if(s1.length() == 0 ){return "";}
                s1 = s1.substring(0,s1.length()-1);
            }
        }
        return s1;

    }

}
