package org.example.dynamic;

/**
 * 最长公共子序列
 * 最经典的二维动态规划
 * @Datetime: 2024/3/6 20:49
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/longest-common-subsequence/description/">最长公共子序列</a>
 */
public class T1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] res = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); ++i) {
            for (int j = 0; j < text2.length(); ++j) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    res[i + 1][j + 1] = res[i][j] + 1;
                } else {
                    res[i + 1][j + 1] = Math.max(res[i + 1][j], res[i][j+ 1]);
                }
            }
        }
        return res[text1.length()][text2.length()];
    }
}
