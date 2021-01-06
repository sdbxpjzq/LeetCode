package _07_树.遍历._145_二叉树的后序遍历_中等;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Solution_2 {
    // todo 注意使用 LinkedList
    LinkedList<Integer> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // todo 头节点最后输出, 头插法
            list.addFirst(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }
}
