package _07_树._257_二叉树的所有路径_简单;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    ArrayList<String> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        m2(root);
        return result;
    }

    void m2(TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            // 最后的结果
            result.add(buildString(path));
            return;
        }
        if (node.left != null) {
            m2(node.left);
            path.remove(path.size() - 1); // 回溯
        }

        if (node.right != null) {
            m2(node.right);
            path.remove(path.size() - 1); // 回溯
        }
    }

    // 单独写一个用来构造字符串的方法。
    public String buildString(List<Integer> path) {
        StringBuilder sPath = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            sPath.append(path.get(i)).append("->");
        }
        sPath.append(path.get(path.size() - 1));
        return sPath.toString();
    }

    public void dfs(TreeNode root) {
        // 递归退出条件
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right==null) {
            paths.add(new ArrayList<>(path));
        }else {
            dfs(root.left);
            dfs(root.right);
        }
        // 回溯
        path.remove(path.size()-1);
    }

}
