package _01_数组;

import java.util.Arrays;

/**
 * 137 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了 三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例1
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例2
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 */
public class _137_只出现一次的数字II_中等 {
    public int singleNumber1(int[] arr) {
        // 先排序
        Arrays.sort(arr);
        int n = arr.length;
        // 在开头
        if (n == 1 || arr[0] != arr[1]) {
            // [1]
            // [1,2,2,2]
            return arr[0];
        }
        // 在结尾
        if (arr[n - 2] != arr[n - 1]) {
            // [2,2,2,3]
            return arr[n - 1];
        }
        // 在中间, 从1开始, 到 n-1
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }
        return 0;
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        // 保留最右边的 1
        int group = tmp & (-tmp);
        for (int y : nums) {
            if ((group & y) == 0) {
                // 分组为 0的组, 组内异或
                res[0] ^= y;
            } else {
                // 分组为 1的组, 组内异或
                res[1] ^= y;
            }
        }
        return res;
    }
}
