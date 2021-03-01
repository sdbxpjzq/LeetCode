package _02_链表._141_环形链表_简单;

import java.util.HashSet;

public class Solution_2 {
    // 快慢指针
    // 最后一个问题，如果存在环，如何判断环的长度呢？
    // 方法是，快慢指针相遇后继续移动，直到第二次相遇。两次相遇间的移动次数即为环的长度。
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // ListNode slow = head; // 走一步
        // ListNode fast = head.next; // fast 走2步
        // while (slow != fast) {
        //     if (fast == null || fast.next == null) {
        //         return false;
        //     }
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // return true;


        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = head.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static String func(String num, int k) {
        String newNum = num;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            for (int j = 0; j < newNum.length()-1; j++) {
                if (newNum.charAt(j) > newNum.charAt(j+1)) {
                    newNum = newNum.substring(0,j)+newNum.substring(j+1, newNum.length());
                    hasCut=true;
                    break;
                }

            }
            // 没有找到, 则删除最后一个数字
            if (!hasCut) {
                newNum = newNum.substring(0,newNum.length()-1);
            }
        }
        return newNum;
    }
}
