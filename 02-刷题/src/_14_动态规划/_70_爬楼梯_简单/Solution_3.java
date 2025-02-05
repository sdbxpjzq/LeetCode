package _14_动态规划._70_爬楼梯_简单;


import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
    //  递归解法,
    //  使用map来存储重复计算的问题
    private Map<Integer, Integer> storeMap = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (null != storeMap.get(n)) {
            return storeMap.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            storeMap.put(n, result);
            return result;
        }
    }
}
