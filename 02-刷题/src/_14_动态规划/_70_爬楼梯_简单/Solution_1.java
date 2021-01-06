package _14_动态规划._70_爬楼梯_简单;


public class Solution_1 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        // 状态容器
        int[] res = new int[n];
        // 初始化
        res[0] = 1;// 上第一个台阶 1种方式
        res[1] = 2; // 上第二个台阶 2种方式

        // 状态方程
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        // 返回最后一个结果值
        return res[n - 1];
    }
}
