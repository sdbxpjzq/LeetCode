package _07_树._101_对称二叉树_简单;

public class Solution_1 {

    public boolean isSymmetric(TreeNode root) {
        //第一次传root让下面顺便进行空判断
        return check(root.left, root.right);
    }

    public boolean check(TreeNode a, TreeNode b) {
        //都为空则没有子树，两个根相等就是对称
        if (a == null && b == null) {
            return true;
        }
        //不满足上面条件，则是一个有子树一个没有那么不对称
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        //三个条件结合
        return check(a.left, b.right) && check(a.right, b.left);
    }
}
