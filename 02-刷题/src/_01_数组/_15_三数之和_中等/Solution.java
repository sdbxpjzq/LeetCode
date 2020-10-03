package _01_数组._15_三数之和_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 数组排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    // 首指针去重
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    // 尾指针去重
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

}
