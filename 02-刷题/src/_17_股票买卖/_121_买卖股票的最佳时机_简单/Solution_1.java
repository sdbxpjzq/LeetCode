package _17_股票买卖._121_买卖股票的最佳时机_简单;

public class Solution_1 {
    /**
     * 更新当前这一天之前股票价格的最低点，那只要最低点不是在今天，那我就可以计算一下今天卖出去能挣多少，
     * 然后跟最大利润比一下就好
     */

    // public int maxProfit(int[] prices) {
    //     //  MAX_VALUE 确保prices数组第一个元素小于初始min
    //     int minPrice = Integer.MAX_VALUE;
    //     int lirun = 0;
    //     for (int i = 0; i < prices.length; i++) {
    //         if (prices[i] < minPrice) {
    //             minPrice = prices[i];
    //         } else {
    //             //卖出
    //             lirun = Math.max(prices[i]-minPrice, lirun);
    //         }
    //     }
    //     return lirun;
    // }
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        //边界状态
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]-prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);

    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int[] price = new int[]{7,1,5,3,6,4};
        int i = maxProfit(price);
        System.out.println(i);
    }
}
