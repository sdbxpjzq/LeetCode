package _07_树._437_路径总和III_中等;

public class Solution {
    int count;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        Sum(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }


    public void Sum(TreeNode root, int sum){
        if(root == null) {
            return;
        }
        sum -= root.val;
        if(sum == 0){
            count++;
        }
        Sum(root.left,sum);
        Sum(root.right,sum);
    }


}
