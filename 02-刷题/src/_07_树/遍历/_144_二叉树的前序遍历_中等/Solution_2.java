package _07_树.遍历._144_二叉树的前序遍历_中等;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Solution_2 {
    LinkedList<Integer>  list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    // 递归
    public  List<Integer> preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            if (node != null) {
                list.add(node.val);
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            else  {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
        return list;
    }
}
