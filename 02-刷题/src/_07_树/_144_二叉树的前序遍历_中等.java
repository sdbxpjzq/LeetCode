package _07_树;

import javax.swing.tree.TreeNode;
import java.util.*;

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
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4,}));
        TreeNode treeNode = createBinaryTree(inputList);
        /**
         *          3
         *        /   \
         *       2     8
         *      / \     \
         *     9  10     4
         *
         */

        // 前序遍历(中 左 右) [3,2,9,10,8,4]
        // List<Integer> list = preorderTraversalV2(treeNode);
        List<Integer> list = preorderTraversalV3(treeNode);
        System.out.println(list);
    }



    /**
     * 漫画算法书 写法 , 成为模板 方便记忆
     */
    public static List<Integer> preorderTraversalV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }

    /**
     * 注意栈的后进先出特性，我们应先将当前节点的右孩子入栈，再将左孩子入栈，这样就可以按照前序遍历的中 → 左 → 右访问二叉树了。
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/kan-de-dong-xue-de-ming-bai-by-novice2master/
     *
     *
     * 先把root给弹出来，把右子树节点压进去，然后左子树节点弹出来，最后右子树弹出来，就完成了根左右的顺序。
     */


    public static List<Integer> preorderTraversalV3(TreeNode root) {
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
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return list;
    }

    /**
     * 递归
     */

    LinkedList<Integer> list = new LinkedList<>();
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 创建二叉树
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；
        // 如果元素非空，继续递归构建该节点的左右孩子。
        if(data != null){
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

}
