package _07_树.遍历._94_二叉树的中序遍历_中等;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Solution_2 {
    LinkedList<Integer> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            } else {
                break;
            }
        }
        return list;
    }
}
