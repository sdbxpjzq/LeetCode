package _13_递归和回溯.回溯._78_子集_中等;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new LinkedList<>());
        helper(nums, new LinkedList<>(), 0);
        return result;
    }

    public void helper(int[] arr,List<Integer> path, int start) {
        if (start >= arr.length) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            result.add(new LinkedList<>(path));
            helper(arr, path,i+1);
            path.remove(path.size()-1);
        }
    }
}
