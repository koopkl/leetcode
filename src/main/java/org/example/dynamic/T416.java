package org.example.dynamic;

/**
 * 分割等和子集
 * 这里分割等和子集，使用的方法为0-1背包问题。
 * 此问题被转换为0-1背包问题，很巧妙呢
 * @Datetime: 2024/2/22 21:48
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">分割等和子集</a>
 */
public class T416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 0) {
            return false;
        }
        sum /= 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len][sum + 1];
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                } else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][sum];
    }
}
