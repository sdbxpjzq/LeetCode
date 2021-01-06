package _14_动态规划._70_爬楼梯_简单;


public class Solution_2 {
    /**
     * 省空间版本
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int cur = 0;
        int pre = 2; //
        int prepre = 1;
        for (int i = 3; i < n; i++) {
            cur = pre + prepre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
