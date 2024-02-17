package org.example.dynamic;

/**
 * 打家劫舍1
 * 最经典的动态规划题目
 * 假如要偷当前的，那么就从前前家的最大值开始偷
 * 加入当前不偷，那么当前家对应的最大值和前面一家一致
 * f(x) = Max(f(x - 2) + x, f(x - 1))
 * @Datetime: 2024/2/17 22:23
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/house-robber/">打家劫舍1</a>
 */
public class T198 {
    public int rob(int[] nums) {
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        res[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            res[i] = Math.max(res[i - 2] + nums[i - 1], res[i - 1]);
        }
        return res[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(new T198().rob(new int[]{2}));

    }
}
