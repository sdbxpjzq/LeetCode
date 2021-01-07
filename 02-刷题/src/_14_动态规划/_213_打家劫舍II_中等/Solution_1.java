package _14_动态规划._213_打家劫舍II_中等;

public class Solution_1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int r1 = rob198(nums, 0, n - 2);
        int nr1 = rob198(nums, 1, n - 1);

        return Math.max(r1, nr1);
    }

    private int rob198(int[] nums, int start, int end) {
        int R = 0;
        int NR = 0;
        for (int i = start; i <= end; i++) {
            int max = Math.max(R, NR);
            R = nums[i] + NR;
            NR = max;
        }
        return 0;
    }
}
