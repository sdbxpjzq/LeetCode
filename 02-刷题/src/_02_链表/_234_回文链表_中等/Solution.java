package _02_链表._234_回文链表_中等;

import java.util.Stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (head != null) {
            Integer val = stack.pop();
            if (!val.equals(head.val)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // public boolean isPalindrome(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return true;
    //     }
    //     ListNode fast = head;
    //     ListNode slow = head;
    //     ListNode pre = head;
    //     // 找链表中间节点
    //     while (fast != null && fast.next != null) {
    //         fast = fast.next.next;
    //         pre = slow;
    //         slow = slow.next;
    //     }
    //
    //     ListNode newHead = null;
    //     if (fast == null) {
    //         // 偶数个 Node节点
    //         // 切断联系
    //         pre.next = null;
    //         // 反转链表
    //         newHead = reverse(slow);
    //     } else {
    //         // 奇数个 Node节点
    //         // 切断联系
    //         pre.next = null;
    //         ListNode next = slow.next;
    //         slow.next = null;
    //         // 反转链表
    //         newHead = reverse(next);
    //     }
    //     // 挨个比较
    //     while (head != null) {
    //         if (head.val != newHead.val) {
    //             return false;
    //         }
    //         head = head.next;
    //         newHead = newHead.next;
    //     }
    //     return true;
    // }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
