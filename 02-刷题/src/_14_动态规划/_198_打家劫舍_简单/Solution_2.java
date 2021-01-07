package _14_动态规划._198_打家劫舍_简单;


public class Solution_2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }

        // 状态容器
        // int[] R = new int[n]; // 偸
        // int[] NR  = new int[n]; // 不偷

        // 初始化
        // R[0] = nums[0];
        // NR[0] = 0; // 不偷 没钱
        int R = 0;
        int NR = 0;

        // 状态方程
        for (int i = 0; i < n; i++) {
            int max = Math.max(R, NR);
            R = NR+nums[i];
            NR = max;
        }
        return Math.max(R, NR);

    }
}
