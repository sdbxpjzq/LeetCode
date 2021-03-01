package _13_递归和回溯.回溯._40_组合求和II_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(candidates,  target, new LinkedList<>(),0);
        return result;
    }

    private void help(int[] arr,  int target, List<Integer> path, int start) {
        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] > target) {
                continue;
            }
            if (i-start>0 && arr[i-1]==arr[i]){
                continue;
            }
            path.add(arr[i]);
            help(arr,target-arr[i], path, i+1);
            path.remove(path.size()-1);
        }
    }
}
