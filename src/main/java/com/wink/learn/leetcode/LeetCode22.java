package com.wink.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * description: LeetCode22 <br>
 * date: 2021/4/30 下午3:27 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode22 {

    private static int anInt=1;

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        System.out.println(ans);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
//        generateAll(new char[2 * n],0,ans);
        nb(ans,"",0,0,n);
        return ans;

    }

    public static void nb(List<String> ans, String anOne, int left, int right, int n){
        if(left < right || left > n){
            return;
        }
        if(left == n && right == n){
            ans.add(anOne);
        }
        nb(ans,anOne+"(",left+1,right,n);
        nb(ans,anOne+")",left,right+1,n);
    }



    public static void generateAll(char[] chars, int pos, List<String> ans){
        int t = anInt;
        anInt = anInt +1;
        System.out.println("=================递归 start" + t);
        System.out.println("===pos  =====" + pos);
        System.out.println("===chars=====" + new String(chars));
        if(chars.length == pos){
            //判断是否合法 前后括号可以对上
            if(isValid(chars)){
                ans.add(new String(chars));
            }
        }else {
            chars[pos] = '(';
            generateAll(chars,pos+1,ans);

            chars[pos] = ')';
            generateAll(chars,pos+1,ans);
        }
        System.out.println("=================递归 over" + t);

    }

    public static boolean isValid(char[] chars){
        int count=0;
        for (char aChar : chars) {
            if(aChar == '('){
                ++count;
            }else {
                --count;
            }

            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }


}
