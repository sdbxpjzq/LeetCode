package _07_树._111_二叉树的最小深度_简单;

public class Solution_1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);


        return 1+ Math.min(leftHeight, rightHeight);
    }
}
