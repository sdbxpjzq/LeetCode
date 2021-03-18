package _01_数组._300_最长递增子序列_中等;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1) {
            return 1;
        }
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
        int[] dp = new int[nums.length];
        // 因为子序列最少也要包含自己，所以长度最小为 1
        Arrays.fill(dp, 1);
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if (dp[i] > result) {
                result = dp[i]; // 取长的子序列
            }
        }
        return result;
    }
}
