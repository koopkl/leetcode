package org.example.array;

/**
 * 搜索二维矩阵
 * @Datetime: 30/1/2024 下午3:32
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/search-a-2d-matrix/description">搜索二维矩阵</a>
 */
public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
