package com.wink.learn.leetcode;

import com.wink.learn.leetcode.common.ListNode;

import java.util.Arrays;

/**
 * description: LeetCode23 <br>
 * date: 2021/5/10 上午10:28 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode23 {

    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        //多个有序链表，合并成一个新的链表
        return merge(0,lists.length,lists);
    }

    public static ListNode merge(int left, int right, ListNode[] lists){
        //递归 结束条件
        if(left > right){
            return null;
        }
        if(left == right){
            return lists[left];
        }
        int mid = (left+right)/2;
        ListNode l = merge(left,mid,lists);
        ListNode r = merge(mid+1,right,lists);

        return mergeTwoLists(l,r);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}
