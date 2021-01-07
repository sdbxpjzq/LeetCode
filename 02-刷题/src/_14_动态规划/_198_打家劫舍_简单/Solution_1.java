package _14_动态规划._198_打家劫舍_简单;


public class Solution_1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==0) {
            return 0;
        }

        // 状态容器
        int[] R = new int[n]; // 偸
        int[] NR  = new int[n]; // 不偷
        // 初始化
        R[0] = nums[0];
        NR[0] = 0; // 不偷 没钱

        // 状态方程
        for (int i = 1; i < n; i++) {
            R[i] = nums[i]+NR[i-1];
            NR[i] = Math.max(R[i-1], NR[i-1]);
        }
        return Math.max(R[n-1], NR[n-1]);

    }
}
