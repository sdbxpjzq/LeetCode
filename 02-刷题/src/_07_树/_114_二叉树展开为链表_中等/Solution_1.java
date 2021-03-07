package _07_树._114_二叉树展开为链表_中等;

public class Solution_1 {
    public void flatten(TreeNode root) {
        help(root);
    }

    public TreeNode help(TreeNode root) {
        // root = null的情况
        if (root == null) {
            return root;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        if (left != null) {
            //注意需要将左子树置null
            root.left = null;
            // 链表链接左子树
            root.right = left;
            // 获得链接的尾节点
            root = help(left);
        }
        if (right != null) {
            // 链表链接右子树
            root.right = right;
            // 获得链接的尾节点
            root = help(right);
        }
        // 返回链接的尾节点
        return root;
    }



}
