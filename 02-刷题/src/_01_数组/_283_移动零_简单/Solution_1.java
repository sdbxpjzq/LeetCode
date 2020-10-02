package _01_数组._283_移动零_简单;

public class Solution_1 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 思路1
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int w = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                // 不等于 0 的数字, 往前移动
                nums[w++] = nums[i];
            }
        }
        if (w < len) {
            // 对剩下的 填充 0
            for (int i = w; i < len; i++) {
                nums[i] = 0;
            }
        }

    }
}
