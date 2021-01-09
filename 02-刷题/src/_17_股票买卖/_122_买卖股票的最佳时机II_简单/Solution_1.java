package _17_股票买卖._122_买卖股票的最佳时机II_简单;

public class Solution_1 {
    public int maxProfit(int[] prices) {
        int max_p = 0;
        // 从1开始循环
        for (int i = 1; i < prices.length; i++) {
            // 只要今天比昨天 贵, 就计算利润
            if (prices[i] > prices[i-1]) {
                max_p+= prices[i]-prices[i-1];
            }
        }
        return max_p;
    }
}
