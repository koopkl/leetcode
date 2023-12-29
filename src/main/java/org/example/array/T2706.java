package org.example.array;

import java.util.Arrays;

/**
 *
 * @Datetime: 29/12/2023 下午2:38
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/buy-two-chocolates/description/">购买两块巧克力</a>
 */
public class T2706 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return money - prices[0] - prices[1] >= 0 ? money - prices[0] - prices[1] : money;
    }
}
