package _02_链表._23_合并K个升序链表_困难;

import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            return o1.val - o2.val;
        });
        for (ListNode head : lists) {
            while (head != null) {
                queue.add(head);
                head = head.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        // 纯粹为了过, 最后设置一下
        cur.next = null;
        return dummy.next;
    }
}
