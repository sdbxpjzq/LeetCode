package _13_递归和回溯.回溯._47_全排列II_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {
    private static List result = new ArrayList<List<Integer>>();



    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public void helper(int[] nums, List<Integer> res, boolean[] visited) {
        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            res.add(nums[i]);
            visited[i] = true;
            helper(nums, res, visited);
            res.remove(res.size() - 1);
            visited[i] = false;
        }
    }


}
