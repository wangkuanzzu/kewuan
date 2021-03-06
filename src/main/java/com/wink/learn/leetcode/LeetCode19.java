package com.wink.learn.leetcode;

import com.wink.learn.leetcode.common.ListNode;

/**
 * description: LeetCode19 <br>
 * date: 2021/4/29 下午4:39 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode19 {

    public static void main(String[] args) {
         ListNode head = new ListNode(1);
        ListNode listNode = head;
        int n = 5;
        for (int i = 2; i < n+1; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        removeNthFromEnd(head,2);
        while(head != null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode ans = new ListNode(0);
         ans.next = head;
         ListNode first = ans.next;
         ListNode second = ans.next;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        while(second.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return ans.next;
    }
}
