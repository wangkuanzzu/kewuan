package order;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * description: XuanZe <br>
 * date: 2020/8/25 10:27 上午 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class XuanZe {

    public static void main(String[] args) {
        int[] in = new int[]{12,3,7,9,2,5,3,10};
        String out = xuanze(in);
        System.out.println(out);
    }

    public static String xuanze(int[] ints){

        for(int i=0; i<ints.length; i++){
            //获取最小值的数组下标
            int temp = i;
            for(int j=i+1; j<ints.length; j++){
                if(ints[j] < ints[temp]){
                    temp = j;
                }
            }
            //交换第一个值与最小值
            int min = ints[temp];
            ints[temp] = ints[i];
            ints[i] = min;
        }

        return Arrays.toString(ints);
    }
}
