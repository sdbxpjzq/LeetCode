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

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        help(root, targetSum);
        return result;
    }
    public void help(TreeNode root, int sum) {
        if (root == null) {
            return;                // 遍历到null节点
        }
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) { // 遍历到叶子节点
            result.add(new ArrayList<>(path));
            // 不能进行return
            // return;
        }else {
            help(root.left,sum);
            help(root.right,sum);
        }
        path.remove(path.size()-1);
    }
}
