package _02_链表;

/**
 *
 * 25. K 个一组翻转链表 困难
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class _25_K个一组翻转链表_困难 {


    /**
     * 题解参考:
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 先找到一段
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                // 剩下的不够 一组
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse206(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse206(ListNode head, ListNode tail) {
        ListNode newHead = null;
        while (head != tail) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public ListNode reverseKGroupV2(ListNode head, int k) {
        // 增加虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义 prev 和 end 结点
        ListNode prev = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 以 k 个结点为条件，分组子链表
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 不足 K 个时不处理
            if (end == null) {
                break;
            }

            // 处理子链表
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            // 翻转子链表
            prev.next = reverseList(start);
            // 将子连表前后串起来
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    // 单链翻转子链
    private ListNode reverseList(ListNode head) {
        if (head== null || head.next == null) {
            return head;
        }
        ListNode  pre = null;
        ListNode first = head;
        while (first != null) {
            ListNode tmp = first.next;
            first.next = pre;
            pre = first;
            first = tmp;
        }
        return pre;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
