package org.example.dynamic;

/**
 * 完全平方数
 * @Datetime: 2024/2/21 20:43
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/perfect-squares/description">完全平方数</a>
 */
public class T279 {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, res[i - j * j]);
            }
            res[i] = 1 + min;
        }
        return res[n];
    }
}
