package com.wink.learn.leetcode.order;

import java.util.Arrays;

/**
 * description: GuiBing <br>
 * date: 2020/8/25 4:05 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class GuiBing {

    public static void main(String[] args) {
        int[] in = new int[]{3,1,4,2,8,7,54,2};
        String out = guibing(in);
        System.out.println(out);
    }

    public static String guibing(int[] ints){
        return  guibing(ints, 0, ints.length-1);
    }

    /**
     *
     * @param ints 数组
     * @param low 开始元素的下标
     * @param high 结束元素的下标
     * @return
     */
    public static String guibing(int[] ints, int low, int high){

        //以中值进行数组的拆分 直到数组中仅存在一个元素即low==high
        int mid = (low+high)/2;
        if(low < high){
            guibing(ints,low,mid);
            guibing(ints,mid+1,high);

            hebing(ints,low,mid,high);
        }

        return Arrays.toString(ints);
    }

    // 实现两个数组合并的方法 数组拆分成ints[low~mid],ints[mid+1~high]
    public static void hebing(int[] ints, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int k = 0;
        int i = low;
        int j = mid+1;

        //合并数组 两个数组中第一个元素 哪个小哪个就先放大临时数组中
        while(i<=mid && j<=high){
            if(ints[i]<ints[j]){
                temp[k++] = ints[i++];
            }else{
                temp[k++] = ints[j++];
            }
        }

        //不确定最大的数在哪一个数组中 所以不管是哪个数组多出的数据 继续追加到临时数组中
        while(i<=mid){
            temp[k++] = ints[i++];
        }
        while(j<=high){
            temp[k++] = ints[j++];
        }

        //临时数组 转移到 元数组中
        for(int x=0; x<temp.length; x++){
            ints[low+x] = temp[x];
        }

    }
}
