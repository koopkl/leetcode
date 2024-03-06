package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵 和 螺旋矩阵II
 * @link <a href="https://leetcode.cn/problems/spiral-matrix/"> 螺旋矩阵</a>
 * @link <a href="https://leetcode.cn/problems/spiral-matrix-ii/"> 螺旋矩阵 II</a>
 */
public class T59 {

    public List<Integer> spiralOrder(int[][] res) {
        List<Integer> ans = new ArrayList<>();
        int x = 0;
        int y = 0;
        int count = 1;
        int m = res.length;
        int n = res[0].length;
        int allCount = m * n;
        int index = 1;
        while (ans.size() < allCount) {
            while (y < n - index) {
                ans.add(res[x][y++]);
            }
            while (x < m - index) {
                ans.add(res[x++][y]);
            }
            if (ans.size() < allCount - 1) {
                while (y >= index) {
                    ans.add(res[x][y--]);
                }
                while (x >= index) {
                    ans.add(res[x--][y]);
                }
                x++;
                y++;
                index++;
            } else if (ans.size() == allCount - 1) {
                ans.add(res[x][y]);
            }
        }
        return ans;
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0;
        int y = 0;
        int count = 1;
        int allCount = n * n;
        int index = 1;
        while (count <= allCount) {
            while (y < n - index) {
                res[x][y++] = count++;
            }
            while (x < n - index) {
                res[x++][y] = count++;
            }
            if (count < allCount) {
                while (y >= index) {
                    res[x][y--] = count++;
                }
                while (x >= index) {
                    res[x--][y] = count++;
                }
                x++;
                y++;
                index++;
            } else if (count == allCount) {
                res[x][y] = count++;
            }
        }
        return res;
    }


}
