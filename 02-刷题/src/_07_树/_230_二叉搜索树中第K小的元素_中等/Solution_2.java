package _07_树._230_二叉搜索树中第K小的元素_中等;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_2 {

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
}
