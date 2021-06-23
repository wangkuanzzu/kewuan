package com.wink.learn.jianzhioffer;

import cn.hutool.core.math.MathUtil;

import java.util.Arrays;

/**
 * description: ArrayDynamic <br>
 * date: 2021/6/4 下午1:35 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ArrayDynamic {

    public static void main(String[] args) {
        int[][] arr = new int[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Math.max(i,j);
            }
        }
        System.out.println("arr = " + Arrays.deepToString(arr));
        int ans = dp(arr);
        System.out.println("ans = " + ans);
    }

    private static int dp(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        //初始化dp矩阵的首行和首列
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        //构造dp矩阵的剩余数据
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + arr[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
