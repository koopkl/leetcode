package org.example.array;

/**
 * 生命游戏
 * @Datetime: 2024/3/15 12:55
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/game-of-life/">生命游戏</a>
 */
public class T289 {
    public void gameOfLife(int[][] board) {
        String tt = "sdfa";
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = board[i][j];
                // 2 代表 细胞原来是 0，变为了1
                // 3 代表 细胞原来是1，变为了0
                int sum = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || k >= m || l < 0 || l >= n || (k == i && j == l)) {
                            continue;
                        }
                        int tempCell = board[k][l];
                        if (tempCell == 1) {
                            sum += 1;
                        } else if (tempCell == 3) {
                            sum += 1;
                        }
                    }
                }
                if (cell == 1) {
                    if (sum < 2) {
                        board[i][j] = 3;
                    } else if (sum > 3) {
                        board[i][j] = 3;
                    }
                } else if (cell == 0) {
                    if (sum == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        new T289().gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
