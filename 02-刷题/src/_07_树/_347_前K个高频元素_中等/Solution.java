package _07_树._347_前K个高频元素_中等;


import java.util.*;

/**
 * 347. 前K个高频元素 中等
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums ={1,1,1,2,2,3};
        topKFrequent(nums,2);
    }

    /**
     *
     *  二叉堆 (优先队列)
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        // 频率统计
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // 建立优先队列, 借助 Lambda 表达式
        // zz 求前 k 大，用小堆，求前 k 小，用大堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> count.get(a) - count.get(b));
        // 也可以借助 compare 比较函数
        // PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         return map.get(a) - map.get(b);
        //     }
        // });


        // 维护一个大小为 k 的已排序的优先队列
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // 返回结果
        int[] result = new int[heap.size()];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.peek();
        }
        return result;
    }
}
