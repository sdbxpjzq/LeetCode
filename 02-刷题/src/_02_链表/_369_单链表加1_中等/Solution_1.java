package _02_链表._369_单链表加1_中等;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_1 {
    public static void main(String[] args) {

    }
    Stack<Integer> stack  = new Stack<>();
    // public ListNode plusOne(ListNode head) {
    //     if (head == null) {
    //         return head;
    //     }
    //     ListNode cur = head;
    //     while (cur!=null) {
    //         stack.push(cur.val);
    //         cur = cur.next;
    //     }
    //     int carry = 1;
    //     while (!stack.isEmpty()) {
    //         Integer tmp = stack.pop();
    //         int sum = tmp.val + carry;
    //         carry = sum / 10;
    //         tmp.val = sum % 10;
    //         if (carry == 0) {
    //             return head;
    //         }
    //     }
    //     if (carry != 0) {
    //         ListNode new_head = new ListNode(1);
    //         new_head.next = head;
    //         return new_head;
    //     }else {
    //         return head;
    //     }
    // }
}
