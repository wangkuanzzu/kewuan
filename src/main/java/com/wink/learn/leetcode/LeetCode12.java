package com.wink.learn.leetcode;

/**
 * description: LeetCode12 <br>
 * date: 2021/3/15 下午4:27 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode12 {

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            System.out.println(intToRoman(i));
        }
        System.out.println("=====");
        for (int i = 100; i <= 1000; i+=100) {
            System.out.println(intToRoman(i));
        }
        System.out.println("=====");
        for (int i = 1000; i <= 2000; i+=1000) {
            System.out.println(intToRoman(i));
        }
    }

    public static String intToRoman(int num) {
        int[] alabo = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] luoma = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < alabo.length; i++) {
            while (num >= alabo[i]) {
                result.append(luoma[i]);
                num -= alabo[i];
            }
        }
        return result.toString();
    }
}
