package _07_树;

import java.util.*;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _145_二叉树的后序遍历_中等 {
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

        // 后序遍历(左 右 中) [9,10,2,4,8,3]
        List<Integer> list = postorderTraversalV2(treeNode);
        System.out.println(list);


    }





    /**
     * 模板记忆
     * 1- 先将先序遍历的根-左-右顺序变为 根-右-左
     * 2- 再翻转变为后序遍历的 左-右-根，翻转还是改变结果res的加入顺序
     * 3- 然后把更新辅助结点p的左右顺序换一下即可
     */
    public static List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                // 头插
                list.addFirst(node.val);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }

        }
        return list;
    }


    /**
     * 递归写法
     */
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }

        // if (root == null) {
        //     return list;
        // }
        // if (root.left != null) {
        //     postorderTraversal(root.left);
        // }
        // if (root.right != null) {
        //     postorderTraversal(root.right);
        // }
        // list.add(root.val);
        return list;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
