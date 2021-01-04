package _07_树._235_二叉搜索树的最近公共祖先_简单;

public class Solution_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            // p, q 都在左子树
            return lowestCommonAncestor(root.left, p,q);
        }else if (p.val > root.val && q.val > root.val) {
            // p, q 都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }else {
            return root;
        }

    }
}
