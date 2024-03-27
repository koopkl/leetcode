package org.example.dynamic;

public class LRC091 {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[costs.length + 1][3];
        for (int i = 0; i < len; i++) {
            dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + costs[i][0];
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]) + costs[i][0];
            dp[i + 1][2] = Math.min(dp[i][1], dp[i][2]) + costs[i][0];
        }
        return Math.min(Math.min(dp[len][0], dp[len][1]), dp[len][2]);
    }

}
