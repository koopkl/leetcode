package org.example.array;

/**
 * 旋转矩阵
 * 原地算法，找到一个的下一个位置
 * 重点为 如何遍历i和j
 * @Datetime: 2024/3/14 18:58
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/rotate-image/">旋转矩阵</a>
 */
public class T48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n -j - 1][i] = matrix[n - j - 1][n - i - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
