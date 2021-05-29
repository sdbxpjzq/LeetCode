package _14_动态规划._213_打家劫舍II_中等;

public class Solution_1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len== 2) return Math.max(nums[0], nums[1]);
        return Math.max(help(nums, 0, len - 2), help(nums, 1, len - 1));
    }

    private int help(int[] nums, int left, int right) {
        int[][] dp = new int[right - left + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[left];
        for (int i = left + 1; i <= right; i++) {
            int index = i - left; // 注意下标的处理方式
            dp[index][0] = Math.max(dp[index - 1][0], dp[index - 1][1]);
            dp[index][1] = Math.max(dp[index - 1][1], dp[index - 1][0] + nums[i]);
        }

        return Math.max(dp[right - left][0], dp[right - left][1]);
    }
}
