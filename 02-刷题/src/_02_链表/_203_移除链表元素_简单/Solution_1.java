package _02_链表._203_移除链表元素_简单;


public class Solution_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);

        dummyNode.next = head;
        ListNode currentNode = dummyNode;
        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            }else {
                currentNode = currentNode.next;
            }
        }
        return dummyNode.next;
    }
}
