package _01_数组._15_三数之和_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        // 数组排序
        Arrays.sort(nums);
       help(nums, 0,0, 3);
        return result;
    }

    /**
     *
     * @param nums
     * @param target
     * @param start
     * @param k 选出 多少个元素
     */
    public static void help(int[] nums, int target, int start, int k) {
        if ()
    }
}
