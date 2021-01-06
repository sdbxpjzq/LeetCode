package _07_树.遍历._144_二叉树的前序遍历_中等;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Solution_2 {
    LinkedList<Integer> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            // 先进后出, 所以先 右子树 先进栈
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return list;
    }
}
