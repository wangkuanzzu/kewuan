package com.wink.learn.jianzhioffer;

/**
 * description: Solution10 <br>
 * date: 2021/7/23 下午2:37 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Solution12 {

    public static void main(String[] args) {

    }

    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            //中间值 左边第一个 右边第一个

            if( numbers[mid] > numbers[high]){
                //最小值在mid+1～high中
                low = mid + 1;
            }else if(numbers[mid] < numbers[high]){
                //最小值在low～mid中
                high = mid;
            }else {
                //最小值位置不确定，但肯定在low～high-1中
                high = high -1;
            }
        }
        return numbers[low];

    }

}
