package _07_树.遍历._144_前序遍历_中等;

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
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        // 也可以是下边这种写法
        // if (root != null) {
        //     return list;
        // }
        // list.add(root.val);
        // if (root.left != null) {
        //     preorderTraversal(root.left);
        // }
        // if (root.right != null) {
        //     preorderTraversal(root.right);
        // }
        return list;
    }
}
