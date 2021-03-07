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

    public static void main(String[] args) {
        int[] data=new int[] {1,0,0,2,2,0,1,1,2,0,2};
        data=sort(data);
        for(int o:data) {
            System.out.println(o);
        }
    }

    public static int[] sort(int[] data) {
        int l = 0;
        int r = data.length - 1;
        int cur = 0;
        while (cur != r) {
            if (data[cur] == 0) {
                swap(data, cur,l);
                l++;
                cur--;
            }
            if (data[cur] == 2) {
                swap(data, cur,r);
                r--;
                cur--;
            }
            cur++;
        }
        return data;
    }
    private static void swap(int[] a, int left, int right) {
        int t = a[left];
        a[left] = a[right];
        a[right] = t;
    }



}
