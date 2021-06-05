package _01_数组._15_三数之和_中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return result;
        }
        // 数组排序, 为了去重
        Arrays.sort(nums);
        help(nums, new ArrayList<>(), 0, 0, 3);
        return result;
    }

    /**
     * @param arr    数组
     * @param target 目标和
     * @param start  从下标几开始
     * @param k      选出 多少个元素求和
     */
    public static void help(int[] arr, List<Integer> path, int target, int start, int k) {
        int len = arr.length;
        if (k > 2) {
            for (int i = start; i < len; i++) {
                if (i > start && arr[i] == arr[i - 1]) {
                    continue;
                }
                if (arr[i] > target) {
                    return;
                }
                path.add(arr[i]);
                help(arr, path, target - arr[i], i + 1, k - 1);
                path.remove(path.size() - 1);
            }
        } else if (k == 2) {
            // 两数求和 双指针, 是一种被迫的方式, 不然会超时
            int left = start, right = len - 1;
            while (left < right) {
                int tmp = arr[left] + arr[right];
                if (tmp < target) {
                    // 去重
                    do {
                        left++;
                    } while (left < right && arr[left] == arr[left - 1]);
                } else if (tmp > target) {
                    // 去重
                    do {
                        right--;
                    } while (left < right && arr[right] == arr[right + 1]);
                } else {
                    path.add(arr[left]);
                    path.add(arr[right]);
                    result.add(new ArrayList<>(path));

                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);

                    // 去重 , 往中间走
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }
    }


    /**
     * @param arr    数组
     * @param target 目标和
     * @param start  从下标几开始
     * @param k      选出 多少个元素
     */
    public void helpV2(int[] arr, List<Integer> path, int target, int start, int k) {
        if (target == 0 && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                return;
            }
            path.add(arr[i]);
            helpV2(arr, path, target - arr[i], i + 1, k);
            path.remove(path.size() - 1);
        }
    }

    /**
     * @param arr    数组
     * @param target 目标和
     * @param start  从下标几开始
     */
    private static void dfs(int[] arr, List<Integer> path, int target, int start, boolean[] visited) {
        // 控制几个数
        if (target == 0 && path.size() == 3) {
            result.add(new ArrayList<>(path));
            return;
        }
        int len = arr.length;
        for (int i = start; i < len; i++) {
            if (visited[i] == true) {
                continue;
            }
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                return;
            }
            visited[i] = true;
            path.add(arr[i]);
            dfs(arr, path, target - arr[i], i + 1, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
