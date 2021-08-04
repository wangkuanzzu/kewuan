package com.wink.learn.jianzhioffer;

import com.wink.learn.leetcode.common.ListNode;

import java.util.Stack;

/**
 * description: Solution06 <br>
 * date: 2021/7/23 下午3:44 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class Solution06 {
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = stack.pop();
        }
        return ans;

    }
}
