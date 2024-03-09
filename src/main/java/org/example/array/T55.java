package org.example.array;

/**
 * 跳跃游戏
 * @Datetime: 2024/3/7 15:50
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">跳跃游戏</a>
 */
public class T55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
