package n02_链表;

import java.util.Stack;

/**
 * 445. 两数相加II 中等
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 */

public class _445_两数相加II_中等 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(5);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(7);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(5);
        node21.next = node22;
        node22.next = node23;

        addTwoNumbers(node11, node21);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        // 利用栈
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int sum = (s1.isEmpty() ? 0 : s1.pop()) +
                    (s2.isEmpty() ? 0 : s2.pop()) + carry;
            ListNode n = new ListNode(sum % 10);
            carry = sum / 10;
            // 头插法
            n.next = head;
            head = n;
        }
        return head;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
