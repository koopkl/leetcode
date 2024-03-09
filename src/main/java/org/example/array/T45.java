package org.example.array;

/**
 * 跳跃游戏2
 * @Datetime: 2024/3/7 17:50
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/jump-game-ii/">跳跃游戏2</a>
 */
public class T45 {
    public int jump(int[] nums) {
        int max = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
