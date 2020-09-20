package n02_链表;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 面试题_02_02_返回倒数第k个节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        head.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        int val = kthToLast(head, 2);
        System.out.println(val);

    }

    /**
     * 设置快和慢两个指针，初始化时快指针比慢指针 先移动k次，
     * 然后两个指针每次都走一步，当快指针到达终点时，慢指针正好处在倒数第k的位置
     * ![](https://youpaiyun.zongqilive.cn/image/20200920160251.png)
     */
    public static int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
