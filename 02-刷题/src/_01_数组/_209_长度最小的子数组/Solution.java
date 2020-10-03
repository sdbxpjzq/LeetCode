package _01_数组._209_长度最小的子数组;

import java.util.List;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = -1;
        int right = -1;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (left <= right) {
            if (sum < s) {
                right++;
                if (right >= nums.length) {
                    break;
                }
                sum += nums[right];
            } else {
                // sum >= s
                minLen = Math.min(minLen, right - left);
                left++;
                if (left > right) {
                    break;
                }
                sum -= nums[left];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
