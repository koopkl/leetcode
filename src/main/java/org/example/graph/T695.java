package org.example.graph;

/**
 * 岛屿的最大面积
 * T200的变种，增加一下统计即可
 * @Datetime: 2024/3/5 20:07
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/max-area-of-island/description/">岛屿的最大面积</a>
 */
public class T695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return dfs(grid, x - 1, y) + dfs(grid, x + 1, y) +
                dfs(grid, x, y + 1) + dfs(grid, x, y - 1) + 1;
    }
}
