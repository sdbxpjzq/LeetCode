package _02_链表._2_两数相加_中等;

public class Solution_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = dummyNode;

        //进位
        int carry = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + carry;
            int val = tmp % 10;
            carry = tmp / 10;
            ListNode node = new ListNode(val);
            currentNode.next = node;
            currentNode = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            while (l1 != null) {
                int tmp = l1.val + carry;
                int val = tmp % 10;
                carry = tmp / 10;
                ListNode node = new ListNode(val);
                currentNode.next = node;
                currentNode = node;

                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                int tmp = l2.val + carry;
                int val = tmp % 10;
                carry = tmp / 10;
                ListNode node = new ListNode(val);
                currentNode.next = node;
                currentNode = node;
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            currentNode.next = node;
            currentNode = node;
        }
        return dummyNode.next;
    }
}
