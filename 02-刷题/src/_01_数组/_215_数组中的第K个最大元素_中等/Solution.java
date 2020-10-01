package _01_数组._215_数组中的第K个最大元素_中等;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素 中等
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        // int num = findKthLargest(nums, 2);
        int num = findKthLargestV2(nums, 2);
        System.out.println(num);
    }

    /**
     *  思路3 优先队列
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num > queue.peek()) {
                // peek 从头部检索
                queue.poll();// poll 从头部 检索 并 删除
                queue.add(num);
            }
        }

        return queue.poll();
    }

    /**
     * 思路2: 利用快排 借助 partition 分区来帮助找到第K大元素
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
