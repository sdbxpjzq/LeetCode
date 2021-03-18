package _01_数组._674_最长连续递增序列_简单;

import java.util.Arrays;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length==1) {
            return 1;
        }
        // dp[i] 表示以 nums[i] 这个数结尾的连续递增子序列的长度。
        int[] dp = new int[nums.length];
        // 因为子序列最少也要包含自己，所以长度最小为 1
        Arrays.fill(dp,1);

        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) { // 连续记录
                dp[i + 1] = dp[i] + 1;
            }
            if (dp[i + 1] > result) {
                result = dp[i + 1];
            }
        }
        return result;
    }
}
