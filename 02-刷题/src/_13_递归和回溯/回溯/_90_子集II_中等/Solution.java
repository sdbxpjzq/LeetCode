package _13_递归和回溯.回溯._90_子集II_中等;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new LinkedList<>());
        // 注意先排序
        Arrays.sort(nums);
        helper(nums, new LinkedList<>(), 0);
        return result;
    }

    public void helper(int[] arr, List<Integer> path, int start) {
        if (start >= arr.length) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                // 去掉重复
                continue;
            }
            path.add(arr[i]);
            result.add(new LinkedList<>(path));
            helper(arr, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
