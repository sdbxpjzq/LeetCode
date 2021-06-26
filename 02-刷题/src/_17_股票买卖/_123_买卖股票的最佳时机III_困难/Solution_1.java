package _17_股票买卖._123_买卖股票的最佳时机III_困难;

public class Solution_1 {
    // 2
    public static int maxProfitForKTime(int[] prices, int k) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        //表格的最大行数
        int n = prices.length;
        //表格的最大列数
        int m = k * 2 + 1;
        //使用一维数组记录数据
        int[] resultTable = new int[m];
        //填充初始状态
        for (int i = 1; i < m; i += 2) {
            resultTable[i] = -prices[0];
        }
        //自底向上，填充数据
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ((j & 1) == 1) {
                    resultTable[j] = Math.max(resultTable[j], resultTable[j - 1] - prices[i]);
                } else {
                    resultTable[j] = Math.max(resultTable[j], resultTable[j - 1] + prices[i]);
                }
            }
        }
        //返回最终结果
        return resultTable[m - 1];
    }

    //3
    public static int helpV2(int k,int[] prices) {
        //如果交易次数小于1，返回0
        if (k < 1) {
            return 0;
        }
        //如果交易次数大于等于数组长度，此时就是第二种情况
        // if (k >= prices.length / 2) {
        //     return stockTrading2(prices);
        // }
        //每一天只有两个状态：买入和卖出
        //但是我们需要考虑次数k限制，所以我们可以增加一个维度描述第几次交易
        //dp[卖出的次数][当前是否持股]=dp[k][i],其中1={0，1}；0表示卖出,1表示持有
        //此时只有两种状态：
        //1.第i次不持有：此时情况为：本来不持有，这次不操作；要么第i次持有现在卖出
        //dp[i][0] = (dp[i][0],dp[i][1]+price)
        //2.第i次持有：此时情况为：本来持有，这次不操作；要么前一次不持有持有现在买入
        //dp[i][1] = (dp[i][1],dp[i-1][0]-price)

        //dp[卖出的次数][当前是否持股]=dp[k][i]
        int[][] dp = new int[k][2];
        //边界值：初始持有的最小值一定要小于prices的最小值
        for (int i = 0; i < k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            //注意要重设第一次交易的初始值，否则存在某一天多次交易问题
            //第一次不持有：要么之前就不持有，此时不操作；要么之前持有，现在第一次卖出入
            dp[0][0] = Math.max(dp[0][0], dp[0][1] + price);
            //第一次持有: 要么之前就是第一次持有，此时不操作；要么之前不持有，现在第一次买入
            dp[0][1] = Math.max(dp[0][1], -price);
            for (int i = 1; i < k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + price);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - price);
            }
        }
        return Math.max(dp[k - 1][0], dp[k - 1][1]);
    }

    public static int stockTrading2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sell = 0, buy = -prices[0], tmp = 0;
        for (int i = 1; i < prices.length; i++) {
            tmp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, tmp - prices[i]);
        }
        return sell;
    }


    // 1
    public int maxProfit(int[] prices) {
        return help(2, prices);
    }

    // 交易k次
    public int help(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // dp[天数][卖出的次数][当前是否持股]=>dp[i][k][j]
        int[][][] dp = new int[prices.length][k + 1][2];
        dp[0][0][0] = 0; // 无股票无交易
        dp[0][0][1] = -prices[0]; // 买股票

        // 注意这个初始值, 需要每天都初始0次交易的情况
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        // 开始交易
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 今天卖出股票交易次数是今天的交易次数
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 今天买入股票交易次数是上一天买入的股票
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        // 最终的交易最大值为卖股票的三种情形下的最大值
        return Math.max(dp[prices.length - 1][k][0],dp[prices.length - 1][k][1]);
    }
}
