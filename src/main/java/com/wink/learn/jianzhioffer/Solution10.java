package com.wink.learn.jianzhioffer;

/**
 * description: Solution10 <br>
 * date: 2021/7/23 下午2:37 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Solution10 {

    public static void main(String[] args) {

        System.out.println(fib(0)+ "==" + fib2(0));
        System.out.println(fib(1)+ "==" + fib2(1));
        System.out.println(fib(2)+ "==" + fib2(2));
        System.out.println(fib(3)+ "==" + fib2(3));
        System.out.println(fib(4)+ "==" + fib2(4));
        System.out.println(fib(5)+ "==" + fib2(5));
    }

    private static int fib(int n){
        if (n==0) {
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    private static int fib2(int n){
        int a= 0,b=1,sum;
        for (int i = 0; i < n; i++) {
            sum = a+b;
            a= b;
            b= sum;
        }
        return a;
    }

}
