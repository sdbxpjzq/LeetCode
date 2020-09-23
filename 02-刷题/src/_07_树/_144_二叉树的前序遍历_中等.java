package _07_树;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _144_二叉树的前序遍历_中等 {


    /**
     * 注意栈的后进先出特性，我们应先将当前节点的右孩子入栈，再将左孩子入栈，这样就可以按照前序遍历的中 → 左 → 右访问二叉树了。
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/kan-de-dong-xue-de-ming-bai-by-novice2master/
     */
    public List<Integer> preorderTraversalV4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node);
            }
            if (node.left != null) {
                stack.add(node);
            }
        }
        return list;
    }

    /**
     * 漫画算法 写法
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                list.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop().right;
            }
        }
        return list;
    }


    /**
     * 递归
     */

    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
