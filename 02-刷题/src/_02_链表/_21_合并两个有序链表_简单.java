package _02_链表;

/**
 * 21. 合并两个有序链表 简单
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _21_合并两个有序链表_简单 {

    /**
     * 一. 迭代大法好
     * 解题思路：
     * <p>
     * 定义一个虚拟节点dummy和一个前进节点cur；
     * 只要两个指针都不指向空，就遍历两个链表，对两个指针所指节点作如下处理：
     * 比较两个节点的值；
     * 将较小的节点放在cur后面，然后再将该节点上的指针往前移动一步；
     * cur也往前移动一步；
     * 将非空的链表接到cur后面（也可以包含均为空的情况，你品！）
     * 只要返回dummy.next即可。
     * <p>
     * 作者：xmblgt
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/di-gui-he-die-dai-liang-chong-fang-fa-zhen-de-ke-y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 时间复杂度：O(m + n)，循环的次数等于 2 个链表的总长度 m + n
     * 空间复杂度：O(1)，使用的变量内存为常数级别
     *
     */
    public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        //下面4行是空判断
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        // dummy: 傀儡, 假
        ListNode dummy = new ListNode(0);
        // cur指针是复制的dummy指针，dummy始终都在头节点处，而cur相当于不断地在穿针引线串联增加节点
        ListNode curr = dummy;
        while (linked1 != null && linked2 != null) {
            //比较一下，哪个小就把哪个放到新的链表中
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = linked1 == null ? linked2 : linked1;
        // dummy是虚拟节点，需要返回的是它后面的链表，也就是dummy.next
        return dummy.next;
    }


    /**
     * 递归法
     * 解题思路：
     * <p>
     * 递归基（递归终止条件）：l1为null,返回l2；l2为空，返回l1。（已经包含了l1和l2均为空的两种情况，你细品！）
     * 递归方法本质：传入的参数为两个链表的头节点指针，是对这两个链表的合并。
     * 因此，只要把节点值小的节点后面的链表和另一个链表继续合并，然后将结果再放在小节点的后面，最后返回小节点即可。（有点绕，直接看代码！）
     * <p>
     * 作者：xmblgt
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/di-gui-he-die-dai-liang-chong-fang-fa-zhen-de-ke-y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 时间复杂度：O(m + n)，每次递归都会添加一个链表节点，最终会递归 m + n 次
     * 空间复杂度：递归的过程中，会将全部 m + n 个节点都保存一次在递归调用栈中
     */
    public ListNode mergeTwoListsV2(ListNode linked1, ListNode linked2) {
        if (linked1 == null) {
            return linked2;
        }
        if (linked2 == null) {
            return linked1;
        }
        if (linked1.val < linked2.val) {
            //如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接
            linked1.next = mergeTwoListsV2(linked1.next, linked2);
            return linked1;
        } else {
            //如果 l2 的 val 值更小，则将 l2.next 与排序好的链表头相接
            linked2.next = mergeTwoListsV2(linked1, linked2.next);
            return linked2;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
