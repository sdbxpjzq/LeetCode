package _01_数组._215_数组中的第K个最大元素_中等;

public class Solution_3 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        // int num = findKthLargest(nums, 2);
        int num = findKthLargest(nums, 2);
        System.out.println(num);
    }

    /**
     * 思路3: 利用快排 借助 partition 分区来帮助找到第K大元素
     */
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int i = partition(nums, left, right);
            if (i == target) {
                return nums[i];
            } else if (i < target) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return 0;
    }

    private int partition(int[] a, int left, int right) {
        int mid = left;
        while (left < right) {
            while (left < right && a[right] >= a[mid]) {
                right--;
            }
            while (left < right && a[left] <= a[mid]) {
                left++;
            }
            if (left < right) {
                swap(a, left, right);
            }
        }
        swap(a, left, mid);
        return left;
    }

    private void swap(int[] a, int left, int right) {
        int t = a[left];
        a[left] = a[right];
        a[right] = t;
    }
}
