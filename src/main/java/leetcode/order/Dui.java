package leetcode.order;

import java.util.Arrays;

/**
 * description: Dui <br>
 * date: 2020/8/25 2:09 下午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Dui {
    public static void main(String[] args) {
        int[] in = new int[]{5,3,6,3,8,1,2,10};
        String out = dui(in);
        System.out.println(out);
    }

    //堆=二叉堆 最大堆和最小堆
    // 最大堆：根结点大于左右子结点
    // 最小堆：根结点小于左右子结点

    //数组与二叉堆的转换
    /**
     * 堆：
     *          1
     *       2     3
     *     5   4 6   7
     *   8
     *   数组：
     *  {1，2，3，5，4，6，7，8}
     */
    // 下标为n的数组元素，在堆中其对应的左右子结点分贝为：2n+1 和 2n+2


    //第一步：给定一个乱序数组按照堆处理 调整为 最大堆
    public static void adjustHeap(int[] ints, int start, int length){
        int temp = ints[start];
        for(int k=start*2+1; k<length; k=k*2+1){
            // 存在右子结点 且右子结点大于左子结点
            if(k+1 < length && ints[k]<ints[k+1]){
                k++;
            }
            // 子结点大于根结点 子结点值覆盖根结点
            if(ints[k] > temp){
                ints[start] = ints[k];
                start = k;
            }else{
                break;
            }
            // 根结点的值覆盖 左右子结点中较大的那个
            ints[start] = temp;
        }

    }

    //第二步：交换数组第一个元素和最后一个元素

    public static void swap(int[] ints, int a, int b){
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }
    //第三步：获取前n-1个数组元素按照堆处理 调整为 最大堆 （重复第一步和第二步）

    public static String dui(int[] ints){
        //创建最大堆
        for (int i=ints.length/2 -1; i >= 0; i--){
            adjustHeap(ints,i,ints.length);
        }
        //交换数组首尾数据 + 调整新堆
        for (int j=ints.length-1; j >= 0; j--){
            swap(ints,0, j);
            adjustHeap(ints,0,j);
        }
        return Arrays.toString(ints);
    }
}
