package _07_树._98_验证二叉搜索树_中等;

import java.util.Stack;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                if (pre != null && node.val <= pre.val)
                    return false;
                //保存前一个访问的结点
                pre = node;
                node = node.right;
            }
        }
        return true;
    }
}
