package _18_子序列.不相邻最大子序列和_中等;

public class Solution {
    // 是一个打家劫舍的问题
    public long subsequence (int n, int[] nums) {
        // write code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = n;
        //dp[房子的位置][选择]
        // 状态容器
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][0] = 0; // 不抢
        dp[0][1] = nums[0]; // 抢
        // 状态方程
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
