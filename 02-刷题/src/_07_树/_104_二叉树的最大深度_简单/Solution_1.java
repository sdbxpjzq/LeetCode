package _07_树._104_二叉树的最大深度_简单;

public class Solution_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1+Math.max(leftHeight, rightHeight);
    }
}
