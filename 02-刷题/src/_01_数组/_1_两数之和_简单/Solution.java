package _01_数组._1_两数之和_简单;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = twoSum(nums, 6);
        for (int re : res) {
            System.out.println(re);
        }

    }
    public static int[] twoSum(int[] nums, int target) {
        // Map (值, 下标)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diffValue = target - nums[i];
            if (map.containsKey(diffValue) && map.get(diffValue) != i) {
                return new int[]{i, map.get(diffValue)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
