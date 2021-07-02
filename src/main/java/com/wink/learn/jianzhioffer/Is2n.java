package com.wink.learn.jianzhioffer;

/**
 * description: Is2n <br>
 * date: 2021/7/1 下午5:19 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Is2n {

    public static void main(String[] args) {
        System.out.println(is2n(15));
        System.out.println(is2n(16));
        //16 = 10000
        //15 = 01111
        // 10000 & 01111 = 00000
        //00000 == 0
    }

    public static boolean is2n(int n){
        return (n & (n - 1)) == 0;
    }
}
