package _01_数组._167_两数之和II_简单;

public class Solution {
    public int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        //因为题目告诉我们一定有解，所以这里随便返回了
        return new int[] { -1, -1 };
    }
}
