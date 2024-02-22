package org.example.dynamic;

/**
 * 零钱兑换
 * 完全背包问题，物品无限，随便拿，装满背包的最小物品数量
 * @Datetime: 2024/2/21 21:17
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/coin-change/description/">零钱兑换</a>
 */
public class T322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] res = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE - 5;
            for (int j = 0; j < coins.length; j++) {
                int temp = i - coins[j];
                if (temp >= 0) {
                    min = Math.min(min, res[temp]);
                }
            }
            res[i] = min + 1;
        }
        return res[amount] > amount ? -1 : res[amount];
    }

    public static void main(String[] args) {
        System.out.println(new T322().coinChange(new int[]{186,419,83,408}, 6249));
    }
}
