package org.example.graph;

/**
 * 岛屿数量
 * 经典数组dfs
 * @Datetime: 2024/3/5 19:56
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/number-of-islands/description/">岛屿数量</a>
 */
public class T200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, i ,j);
                res++;
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x + 1 , y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
