package _01_数组._215_数组中的第K个最大元素_中等;

import java.util.PriorityQueue;

public class Solution_2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 6};
        int num = findKthLargest(nums, 2);
        System.out.println(num);
    }

    /**
     * 使用优先队列
     */
    public static int findKthLargest(int[] nums, int k) {
        // 默认是最小优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                if (num > queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        return queue.poll();
    }
}
