package org.example.array;

/**
 * 有效的数独
 * 遍历即可，但是一次遍历保存一下哦
 * @Datetime: 2024/3/5 17:27
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/valid-sudoku/description/">有效的数独</a>
 */

public class T36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowMap = new int[9][9];
        int[][] colMap = new int[9][9];
        int[][][] all = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j] - '0';
                if (num < 0) {
                    continue;
                }
                rowMap[i][num - 1] += 1;
                colMap[j][num - 1] += 1;
                all[i / 3][j / 3][num - 1] += 1;
                if (rowMap[i][num - 1] > 1 || colMap[j][num - 1] > 1 || all[i / 3][j / 3][num - 1] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T36().isValidSudoku
                (new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
