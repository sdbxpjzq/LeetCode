package _01_数组._283_移动零_简单;

public class Solution_2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 思路2
     *
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (nums[i] != 0) {
            //     int tmp = nums[i];
            //     nums[i] = nums[j];
            //     nums[j] = tmp;
            //     j++;
            // }

            // 优化版本 , 阻止 i==j 的交换
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
