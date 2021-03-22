package _07_树.Z型遍历;

import _07_树.构建二叉树.CreateBT;

import java.util.*;

public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    public void zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // 遍历标志
        int flag = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (flag == 0) {
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

            }
            // 标记下一层处理的方向
            flag = 1 - flag;
            res.add(tmp);
        }
        System.out.println(res);
    }
}
