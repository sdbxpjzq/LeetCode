package _14_动态规划._198_打家劫舍_简单;


public class Solution_1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
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
