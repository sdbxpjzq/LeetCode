package _07_树;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 *
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _230_二叉搜索树中第K小的元素_中等 {

    /**
     * 利用二叉搜索树的 中序遍历, 得带有序数组
     * 利用栈的方式 以加快速度，因为这样可以不用遍历整个树，可以在找到答案后停止。
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            }else {
                 node = stack.pop();
                 //zz 提升效率, 不必遍历全树
                 if (--k ==0) {
                     return node.val;
                 }
                 list.add(node.val);
                 node = node.right;
            }
        }
        return 0;
    }


    public class TreeNode {
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
}
