package _13_递归和回溯.回溯._47_全排列II_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1 {
    private List result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        //注意 先排序
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public void helper(int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            helper(nums, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }


}
