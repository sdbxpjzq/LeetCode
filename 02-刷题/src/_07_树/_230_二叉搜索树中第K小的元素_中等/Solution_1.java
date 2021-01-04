package _07_树._230_二叉搜索树中第K小的元素_中等;

public class Solution_1 {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (leftCount + 1 == k) {
            return root.val;
        } else if (k <= leftCount) {
            // 左子树
            return kthSmallest(root.left, k);
        } else {
            // 右子树
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }
}
