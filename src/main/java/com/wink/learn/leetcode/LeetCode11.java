package com.wink.learn.leetcode;

/**
 * description: LeetCode11 <br>
 * date: 2021/3/12 下午2:38 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode11 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(ints));
    }

    public static int maxArea(int[] height) {
        //排除非法情况
        if(height.length < 2){
            return 0;
        }
        //面积
        int ret = 0;

        //左右指针，向中间靠拢
        int i = 0;
        int j = height.length-1;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            ret = Math.max(ret, h * (j - i));
            if(height[i]<height[j]){
                ++i;
            }else{
                --j;
            }

        }
        return ret;
    }
}
