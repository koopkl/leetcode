package org.example.dynamic;

/**
 * 买股票最佳时机2
 * 动态规划，规划的是最终的结果，这个是相当的重要的，即数据里面最终保存的一定和最终结果直接相关。
 * @Datetime: 2024/3/7 15:07
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">买股票最佳时机</a>
 */
public class T122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] res = new int[len + 1][2];
        res[0][1] = -prices[0];
        for (int i = 0; i < len; i++) {
            res[i + 1][0] = Math.max(res[i][0], res[i][1] + prices[i]);
            res[i + 1][1] = Math.max(res[i][1], res[i][0] - prices[i]);
        }
        return res[len][0];

    }
}
