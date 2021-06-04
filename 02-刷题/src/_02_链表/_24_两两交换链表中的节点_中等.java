package _02_链表;

/**
 *24. 两两交换链表中的节点 中等
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class _24_两两交换链表中的节点_中等 {
    /**
     * 循环实现方式
     *
     * 先尝试 去交换 前2个
     *![](https://youpaiyun.zongqilive.cn/image/20200926091102.png)
     *
     */
    // public ListNode swapPairs(ListNode head) {
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;
    //
    //     ListNode cur = dummy;
    //     while (head != null && head.next != null) {
    //         ListNode firstNode = head;
    //         ListNode secondNode = firstNode.next;
    //
    //         cur.next = secondNode;
    //         firstNode.next = secondNode.next;
    //         secondNode.next = firstNode;
    //
    //         cur = firstNode;
    //         head = firstNode.next;
    //
    //         /*ListNode cur = pre.next;
    //         ListNode future = pre.next.next;
    //
    //         pre.next = future;
    //         cur.next = future.next;
    //         future.next = cur;
    //
    //         pre = pre.next.next;*/
    //
    //     }
    //
    //     return dummy.next;
    // }


    /**
     * 递归实现方式
     *
     * 从链表的头节点 head 开始递归。
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode表示要交换的两个节点。
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     */
    // public ListNode swapPairsV2(ListNode head) {
    //     if ((head == null) || (head.next == null)) {
    //         return head;
    //     }
    //     ListNode firstNode = head;
    //     ListNode secondNode = head.next;
    //     firstNode.next  = swapPairs(secondNode.next);
    //     secondNode.next = firstNode;
    //     return secondNode;
    // }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode swapPairs(ListNode head) {
        // 先找到一段
        int k = 2;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                // 剩下的不够 一组
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse206(head, tail);
        head.next = swapPairs(tail);
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


}
