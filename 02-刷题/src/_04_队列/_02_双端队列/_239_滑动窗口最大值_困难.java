package _04_队列._02_双端队列;

import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *  
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _239_滑动窗口最大值_困难 {
    public static void main(String[] args) {
        int[] num = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(num, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 双端队列 (单调队列)
     * 在双端队列中，要始终保证队头是队列中最大的值或最小值
     * todo 需要总结 https://mp.weixin.qq.com/s/vM6ha7Wwp_EkfRMfLg1dZQ
     * https://mp.weixin.qq.com/s/kyae7wCXII4P_ZytE-OF0A
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 注意这里存储的是元素在数组中的下 标，不是元素的值
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 在尾部添加元素，并保证左边元素都比尾部大
            // getLast - 列表尾部的最后一个元素
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                // removeLast() 移除尾部元素
                deque.removeLast();
            }
            // 下标加入队尾
            deque.addLast(i);

            // 删除头部元素
            //getFirst() 获取头部元素
            if (!deque.isEmpty() && deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            // 当窗口的长度大于等于k个的时候才开始计算（注意这里的i是从0开始的）
            if (i >= k - 1) {
                // 队头元素是队列中最大的，把队列头部的元素加入到数组中
                res[index++] = nums[deque.getFirst()];
            }
        }
        return res;
    }


    /**
     * 暴力法
     */
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        //边界条件判断
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int res[] = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            int max = nums[i];
            //在每个窗口内找到最大值
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            res[i] = max;
        }
        return res;
    }

}
