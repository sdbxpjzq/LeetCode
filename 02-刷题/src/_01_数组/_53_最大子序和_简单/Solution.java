package _01_数组._53_最大子序和_简单;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum = dp[0];

        /**
         * 设sum[i]为以第i个元素结尾且和最大的连续子数组。假设对于元素i，
         * 所有以它前面的元素结尾的子数组的长度都已经求得，那么以第i个元素结尾且和最大的连续子数组实际上，
         * 要么是以第i-1个元素结尾且和最大的连续子数组加上这个元素，要么是只包含第i个元素，即sum[i]= max(sum[i-1] + a[i], a[i])。
         */
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
}
