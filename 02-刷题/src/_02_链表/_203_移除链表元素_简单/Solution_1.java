package _02_链表._203_移除链表元素_简单;


public class Solution_1 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
