package _07_树._110_判断平衡二叉树_简单;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(depth(root.left) - depth(root.right)) <= 1;

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
