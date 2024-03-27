package org.example.array;

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球
 * @Datetime: 2024/3/22 22:01
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description">用最少数量的箭引爆气球</a>
 */
public class T452 {
    int begin;
    int end;
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a ,b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int res = 1;
        begin = points[0][0];
        end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (!check(points[i])) {
                res++;
                begin = points[i][0];
                end = points[i][1];
            }
        }
        return res;
    }

    public boolean check(int[] nums) {
        if (nums[0] <= end) {
            end = Math.min(end, nums[1]);
            begin = Math.min(nums[0], begin);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
