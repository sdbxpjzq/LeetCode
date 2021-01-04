package _07_树._114_二叉树展开为链表_中等;

public class Solution_1 {
    public void flatten(TreeNode root) {
        preOrder(root);
    }

    public TreeNode preOrder(TreeNode current) {
        // root = null的情况
        if (current == null) {
            return current;
        }
        TreeNode right = current.right;
        TreeNode left = current.left;

        if (left != null) {
            //注意需要将左子树置null
            current.left = null;
            // 链表链接左子树
            current.right = left;
            // 获得链接的尾节点
            current = preOrder(left);
        }

        if (right != null) {
            // 链表链接右子树
            current.right = right;
            // 获得链接的尾节点
            current = preOrder(right);
        }
        // 返回链接的尾节点
        return current;
    }
}
