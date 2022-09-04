package _01_数组._109_有序链表转换二叉搜索树_中等;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return help(head);
    }

    private TreeNode help(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 找链表的中间节点
        ListNode slow = head, fast=head;
        ListNode slowPre = null; // slow 的前一个节点
        while (fast!= null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPre.next = null; // left 走到slow就不需要再往后走了, 所以要断开
        // slow 就是中间节点
        TreeNode root = new TreeNode(slow.val);
        root.left = help(head);
        root.right = help(slow.next);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
