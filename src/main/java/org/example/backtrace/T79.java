package org.example.backtrace;

/**
 * 单词搜索
 * 不要怀疑dfs的暴力！！搜索哪有不暴力的呢？尽力剪枝
 * @Datetime: 2024/2/26 17:15
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/word-search/description/">单词搜索</a>
 */
public class T79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, int index,  String word) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || index >= word.length()
                || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        board[x][y] = ' ';
        boolean res = dfs(board, x + 1, y, index + 1, word) || dfs(board, x - 1, y, index + 1, word) ||
                dfs(board, x, y + 1, index + 1, word) || dfs(board, x, y - 1, index + 1, word);
        board[x][y] = word.charAt(index);
        return res;
    }

}
