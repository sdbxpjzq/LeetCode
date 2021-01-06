package _07_树.遍历._145_二叉树的后序遍历_中等;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution_1 {
    LinkedList<Integer> list = new LinkedList<>();

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }
}
