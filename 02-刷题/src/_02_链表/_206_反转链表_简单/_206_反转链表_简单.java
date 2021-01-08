package _02_链表._206_反转链表_简单;

import java.util.List;


public class _206_反转链表_简单 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        ListNode listNode = reverseListV2(a1);


    }

        /**
         * 两两 互换
         * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
         */
    public static ListNode reverseListV2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 利用栈
     */
    // public ListNode reverseList(ListNode head) {
    //
    // }


}
