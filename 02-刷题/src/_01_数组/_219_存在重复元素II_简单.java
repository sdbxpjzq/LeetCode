package _01_数组;

import java.util.HashSet;

/**
 * 219 存在重复元素 II
 *给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *示例1
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例2
 *输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 *示例3
 *输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class _219_存在重复元素II_简单 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len<2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() == k+1) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        int len = nums.length;
        if (len<2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (set.add(nums[i])) {
                if (set.size() == k+1) {
                    set.remove(nums[i-k]);
                }
            }else {
                return true;
            }
        }
        return false;
    }
}
