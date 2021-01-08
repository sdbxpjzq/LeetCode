package _02_链表._92_反转链表II_中等;

import java.util.List;

public class Solution_1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode currentNode = dummyNode;

        ListNode m_node = head;
        ListNode n_node = head;

        // 找到m 和 n 节点,
        // 移动m-1 和 n-1步 找到
        for (int i = 1; i <= m - 1; i++) {
            m_node = m_node.next;
            // 移动current
            currentNode = currentNode.next;
        }
        for (int i = 1; i <= n - 1; i++) {
            n_node = n_node.next;
        }

        while (m_node != n_node) {
            currentNode.next = m_node.next;
            m_node.next=n_node.next;
            n_node.next=m_node;
            // m_node 往前移动
            m_node = currentNode.next;

        }
        return dummyNode.next;
    }
}
