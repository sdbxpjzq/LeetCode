package _01_数组._215_数组中的第K个最大元素_中等;

public class Solution_3 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        // int num = findKthLargest(nums, 2);
        int num = findKthLargestV2(nums, 2);
        System.out.println(num);
    }

    /**
     * 思路3: 利用快排 借助 partition 分区来帮助找到第K大元素
     */
    public static int findKthLargestV2(int[] nums, int k) {
        int length = nums.length;
        int target = length - k;
        int left = 0, right = length -1;
        while (true) {
            int i = partition(nums, left, right);
            if (i == target) {
                return nums[i];
            }else if (i < target ) {
                left = i+1;
            }else {
                right = i-1;
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
            }
            while (left<right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
            }
        }
        nums[left] = pivot;
        return left;
    }


}
