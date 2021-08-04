package com.wink.learn.jianzhioffer;

/**
 * description: Solution04 <br>
 * date: 2021/7/23 下午3:03 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Solution04 {

    public static void main(String[] args) {

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return false;
        }

        int i,j;
        i = 0; //行
        j = matrix[0].length-1; //列
        while(i < matrix.length && j >= 0){
            if (target == matrix[i][j]) {
                return true;
            }
            if (target>matrix[i][j]) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
