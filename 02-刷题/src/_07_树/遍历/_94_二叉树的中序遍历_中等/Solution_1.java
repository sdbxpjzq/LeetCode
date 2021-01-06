package _07_树.遍历._94_二叉树的中序遍历_中等;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution_1 {
    LinkedList<Integer> list = new LinkedList<>();

    /**
     *递归写法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
