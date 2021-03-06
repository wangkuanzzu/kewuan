package com.wink.learn.leetcode;

import com.wink.learn.leetcode.common.ListNode;

/**
 * description: LeetCode21 <br>
 * date: 2021/4/30 下午3:14 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode21 {

    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
