package leetcode.order;

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
                // 交换上面的两个元素位置
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
