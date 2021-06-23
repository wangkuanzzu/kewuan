package com.wink.learn.leetcode.order;


import java.util.Arrays;

/**
 * description: MaoPao <br>
 * date: 2020/8/24 6:38 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class MaoPao {

    public static void main(String[] args) {
        int[] in = new int[]{9,3,2,5,1,3,4,7};
        String out = maopao(in);
        System.out.println(out);
    }



    public static String maopao(int[] ints){
        int temp;
        for(int i=0; i<ints.length; i++){
            for(int j=i+1; j<ints.length; j++){
                if(ints[i]>ints[j]){
                    temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        return Arrays.toString(ints);
    }

}
