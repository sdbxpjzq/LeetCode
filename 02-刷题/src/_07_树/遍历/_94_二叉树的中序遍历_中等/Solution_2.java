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
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()) {
            if (node!=null) {
                stack.push(node);
                node = node.left;
            }else {
                 node = stack.pop();
                 list.add(node.val);
                 node = node.right;
            }
        }
        return list;
    }
}
