package _07_树._112_路径总和_简单;

public class Solution_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;                // 遍历到null节点
        }
        if (root.left == null && root.right == null) { // 遍历到叶子节点
            return sum - root.val == 0;                  // 如果满足这个就返回true
        }
        // 左子树 或者 右子树存在 就行
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);      // 大问题转成两个子树的问题
    }

    public static int findDuplicate(int[] nums) {
        int left = 1; // 数字从1开始. 非下标
        int right = nums.length - 1; // 在 1 和 n 之间
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
