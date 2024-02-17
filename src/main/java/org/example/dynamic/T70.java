package org.example.dynamic;

/**
 * 爬楼梯
 * @Datetime: 2024/2/18 1:43
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/climbing-stairs/description">爬楼梯</a>
 */
public class T70 {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        return res[n];
    }
}
