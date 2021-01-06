package _07_树.遍历._102_二叉树的层序遍历_中等;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _层序遍历 {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    ArrayList<Integer> list = new ArrayList<>();

    //层序遍历 利用队列
    public List<Integer> levelOrderV(TreeNode root) {
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
}
