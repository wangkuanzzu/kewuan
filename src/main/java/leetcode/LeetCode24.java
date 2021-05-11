package leetcode;

import leetcode.common.ListNode;

/**
 * description: LeetCode24 <br>
 * date: 2021/5/11 上午11:49 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class LeetCode24 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        ListNode l = node1;
        while(l != null){
            System.out.println(l.val);
            l=l.next;
        }
        System.out.println("=============");
        ListNode l2 = swapPairs(node1);
        while(l2 != null){
            System.out.println(l2.val);
            l2=l2.next;
        }

    }

    //链表的反转
    public static ListNode reveres(ListNode head){
        ListNode ans = null; //反转后链表头节点
        ListNode curr = head; //当前节点
        ListNode next; //记录下一个节点
        while(curr != null){
            //当前节点的下一个节点
            next = curr.next;
            //已完成反转的节点 连接到当前节点后面
            curr.next = ans;
            //将新的已完成反转的链表的头节点 赋值给返回结果
            ans = curr;
            //当前节点修改为下一个节点
            curr = next;
        }
        return ans;
    }

    //链表相邻两个节点交换
    public static ListNode swapPairs(ListNode head) {
        //引入新的头节点
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode tmp = ans;
        while(tmp.next != null && tmp.next.next != null){
            //获取最近的两个节点
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            //交换节点指向
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //下次循环起点
            tmp = node1;
        }

        return ans.next;
    }
}
