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
        int[] in = new int[]{3,2,7,1,45,23,7,9};
        String out = charu(in);
        System.out.println(out);
    }

    /**
     * 理解插入排序
     * 从数组的第二个元素作为参照数开始向后循环
     * 定义一个指针首先指向第一个元素
     * 逐一比较参照数与参照数之前的元素
     * 如果比之前的数小，则将该指针指向的数向后移动
     * 如此下去 直到指针不存在或参照数大于等于指针指向的元素
     * 将参照数替换当前指针+1的指向位置
     * @param ints
     * @return
     */
    public static String charu(int[] ints){

        for (int i=1; i<ints.length; i++ ){
            // 要操作的数
            int temp = ints[i];
            int last = i-1;
            // 比操作数大的数移动到下标+1的位置
            while (last >= 0 && temp < ints[last]){
                ints[last+1] = ints[last];
                System.out.println("ints = " + Arrays.toString(ints));
                last--;
            }
            ints[last+1] = temp;
            System.out.println("ints ==== " + Arrays.toString(ints));

        }
        return Arrays.toString(ints);
    }
}
