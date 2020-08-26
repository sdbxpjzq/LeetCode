package 数组;

import java.util.*;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；
 * 同时，你不能在买入前卖出股票。
 * <p>
 * 示例2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 思路: 求最大差值
 */
public class N121_买卖股票的最佳时机_简单 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // 输出5
        // int[] prices = {7, 6, 4, 3, 1}; // 输出0
        // int[] prices = {2, 4, 1};
        int i = new N121_买卖股票的最佳时机_简单().maxProfit(prices);
        System.out.println("最终利润: " + i);
    }

    /**
     * 效率不高 O(n^2) 暴力法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int lirun = 0;
        int length = prices.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length; j++) {
                if (prices[j] - prices[i] > lirun && j > i) {
                    lirun = prices[j] - prices[i];
                    System.out.println("第" + (i + 1) + "天买入, 第" + (j + 1) + "天卖出, 利润: " + lirun);
                }
            }
        }
        return lirun;
    }

    /**
     * todo 动态规划
     * 更新当前这一天之前股票价格的最低点，那只要最低点不是在今天，那我就可以计算一下今天卖出去能挣多少，然后跟最大利润比一下就好
     *  public int maxProfit(int prices[]) {
     *         int minprice = Integer.MAX_VALUE;
     *         int maxprofit = 0;
     *         for (int i = 0; i < prices.length; i++) {
     *             if (prices[i] < minprice)
     *                 minprice = prices[i];
     *             else if (prices[i] - minprice > maxprofit)
     *                 maxprofit = prices[i] - minprice;
     *         }
     *         return maxprofit;
     *     }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
