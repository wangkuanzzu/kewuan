package com.wink.learn.jianzhioffer;

/**
 * description: Solution10 <br>
 * date: 2021/7/23 下午2:37 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Solution11 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {

        /**
         * 思路
         *
         */

        String[] words = word.split("");

        boolean f = true;
        for (String w : words) {
            int i=0,j=0;
            while(i < board[0].length && j < board.length){
                if(w.equals(board[i][j])){
                    continue;
                }
            }
        }


        return false;
    }

}
