package com.wink.learn.leetcode;

import java.util.Arrays;

/**
 * description: LeetCode16 <br>
 * date: 2021/4/27 下午5:37 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode16 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,1,1,1};
        int target = 1;
        System.out.println(threeSumClosest(ints,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];
        //定义三个指针 first second third
        for (int first = 0; first < length; first++) {

            if(first > 0 && nums[first] == nums[first -1]){
                continue;
            }
            int second = first + 1;
            int third = length - 1;
            while(second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if(sum == target){
                    return target;
                }

                //不等的时候 计算绝对值
                if(Math.abs(sum - target) < Math.abs(close - target)){
                    close = sum;
                }
                if(sum > target){
                    //third向左移动
                    int third0 = third - 1;
                    //移动过程中相邻两个值相等，继续移动
                    while(second < third0 && nums[third] == nums[third0]){
                        third0--;
                    }
                    third = third0;
                }else {
                    //second向右移动
                    int second0 = second + 1;
                    //移动过程中相邻两个值相等，继续移动
                    while(second0 < third && nums[second] == nums[second0]){
                        second0++;
                    }
                    second = second0;
                }
            }
        }
        return close;

    }

}
