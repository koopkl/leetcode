package org.example.dynamic;

/**
 * 最长递增子序列
 * O n^2 动态规划
 * 贪心
 * @Datetime: 2024/2/22 16:08
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">最长递增子序列</a>
 */
public class T300 {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length + 1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, res[j]);
                }
            }
            res[i] = tempMax + 1;
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
