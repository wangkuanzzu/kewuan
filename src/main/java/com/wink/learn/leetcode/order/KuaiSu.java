package com.wink.learn.leetcode.order;

import java.util.Arrays;

/**
 * description: KuaiSu <br>
 * date: 2020/8/26 10:12 上午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class KuaiSu {

    public static void main(String[] args) {
        int[] in = new int[]{6,1,3,7,9,4,2,8};
        String out = kuaisu(in);
        System.out.println(out);
    }

    public static String kuaisu(int[] ints){
        kuaisu(ints, 0, ints.length-1);
        return Arrays.toString(ints);
    }

    /**
     * 理解快速排序
     * 首先快速排序是一个递归过程，递归函数参数为数组和首位下标
     * 确定一个基准值，随机从数组中选择即可，下面实现默认数组第一个元素
     * 该基准值用于将数组划分为两部分，规则为：左侧数组为小于该基准值，右侧为大于
     * 递归左右两个数组，继续将数组划分为两部分，递归往复
     * （左右两部分数组为无序的）
     * 实现思路：
     * 定义两个指针，分别指向数组的第一个和最后一个元素
     * 左指针向右移动，右指针向左移动，直到两个指针重合
     * 在还没有重合的过程中
     *  找到左右两部分数组中不满足上诉规则的元素进行调换
     * 等待重合时
     *  将重合时指针对应的元素赋值给第一个元素
     *  将基准值赋值给重合时候指针对应的元素
     *
     * @param ints
     * @param low 开始元素下标
     * @param high 结束元素下标
     * @return
     */
    public static void kuaisu(int[] ints, int low, int high){
        if(low > high){
            return;
        }

        int i = low;
        int j = high;
        int base = ints[low];

        int x,y;
        while(i < j){
            // 从右向左 找到比基准值小的第一个元素下标
            while(ints[j] >= base && i < j){
                j--;
            }

            // 从左向右 找到比基准值大的第一个元素下标
            while(ints[i] <= base && i < j){
                i++;
            }
            if(i<j){
                // 交换上面的两个位置的元素
                x = ints[i];
                y = ints[j];

                ints[i] = y;
                ints[j] = x;
            }

        }
        //结束以上循环时 i=j 交换基准值与下标为i的元素
        ints[low] = ints[i];
        ints[i] = base;
        //递归调用左侧
        kuaisu(ints,low,j-1);
        //递归调用右侧
        kuaisu(ints,j+1,high);

    }


}
