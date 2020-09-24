package _07_树;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _102_二叉树的层序遍历_中等 {
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

        // 层序遍历 [3,2,8,9,10,4]
        // List<Integer> list = levelOrderV(treeNode);
        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);
    }

    /**
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null) {
            return res;
        }

        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }


    //层序遍历 利用队列
    public static List<Integer> levelOrderV(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }

        // 加入队列
        queue.add(root);
        while (!queue.isEmpty()) {
            // zz 出队首的元素
            TreeNode node = queue.poll();
            list.add(node.val);
            //zz 将元素的 左右孩子入队
            if (node.left !=null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
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
