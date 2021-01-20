package _17_股票买卖._121_买卖股票的最佳时机_简单;

public class Solution_1 {
    /**
     *
     * 更新当前这一天之前股票价格的最低点，那只要最低点不是在今天，那我就可以计算一下今天卖出去能挣多少，
     * 然后跟最大利润比一下就好
     *
     */

    public int maxProfit(int[] prices) {
        //  MAX_VALUE 确保prices数组第一个元素小于初始min
        int minPrice = Integer.MAX_VALUE;
        int lirun = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                //卖出
                lirun = Math.max(prices[i]-minPrice, lirun);
            }
        }
        return lirun;
    }
}
