package _02_链表._2_两数相加_中等;

public class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        //进位
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;
            int tmp = n1 + n2 + carry;
            int val = tmp % 10;
            carry = tmp / 10;
            ListNode node = new ListNode(val);
            currentNode.next = node;
            currentNode = node;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummyNode.next;
    }
}
