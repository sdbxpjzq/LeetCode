package _02_链表._141_环形链表_简单;

import java.util.HashSet;

public class Solution_1 {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next ==null) {
            return false;
        }

        HashSet<ListNode> set = new HashSet<>();
        while (head.next!=null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
