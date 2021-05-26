package leetcode.function;

/**
 * Description:合并两个有序的链表
 * <p>
 * Created By kuan on 2020/1/15
 */
public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }

    }

    public static ListNode mergeLists2(ListNode l1, ListNode l2) {
        // 记录第一个node
        ListNode templ = new ListNode(-1);
        // 添加第一个node后面的node
        ListNode head = templ;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 :l1;
        // 返回第一个node后的node
        return templ.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l111 = new ListNode(4);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l222 = new ListNode(4);
        l2.next = l22;
        l22.next = l222;

//        ListNode l = mergeLists(l1, l2);
//        while (l != null) {
//            System.out.println(l.val);
//            l = l.next;
//        }

        System.out.println("===================");

        ListNode ll = mergeLists2(l1, l2);
        while (ll != null) {
            System.out.println(ll.val);
            ll = ll.next;
        }
    }
}
