package com.wink.learn.leetcode.order;

import java.util.Arrays;

/**
 * description: ChaRu <br>
 * date: 2020/8/25 11:19 上午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ChaRu {

    public static void main(String[] args) {
        int[] in = new int[]{2,3,7,1,45,23,7,9};
        String out = charu(in);
        System.out.println(out);
    }

    public static String charu(int[] ints){

        for (int i=1; i<ints.length; i++ ){
            // 要操作的数
            int temp = ints[i];
            int last = i-1;
            // 比操作数大的数移动到下标+1的位置
            while (last >= 0 && temp < ints[last]){
                ints[last+1] = ints[last];
                last--;
            }
            ints[last+1] = temp;
            System.out.println("ints = " + Arrays.toString(ints));

        }
        return Arrays.toString(ints);
    }
}
