package _01_数组._33_搜索旋转排序数组_中等;

public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // 左半段有序
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半段有序
                // target 大于重点并且小于最末元素则在
                if (target <= nums[nums.length - 1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // public int search(int[] nums, int target) {
    //     int cutOff = -1;
    //     // 找到 旋转点
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] > nums[i + 1]) {
    //             cutOff = i;
    //             break;
    //         }
    //     }
    //     int left = binarySearch(nums, 0, cutOff, target);
    //     int right = binarySearch(nums, cutOff + 1, nums.length - 1, target);
    //     return left == -1 ? right : left;
    // }

    public int binarySearch(int[] arr, int start, int end, int target) {
        // 当 start > end 时，说明递归整个数组，但是没有找到
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target > arr[mid]) { // 向 右递归
            return binarySearch(arr, mid + 1, end, target);
        } else if (target < arr[mid]) { // 向左递归
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return mid;
        }
    }
}
