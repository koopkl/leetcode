package org.example.dynamic;

import java.util.Arrays;

/**
 * 乘积最大子数组
 * 这里和最大连续子数组之和有一些不同，需要考虑正负
 * @Datetime: 2024/2/22 16:20
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/maximum-product-subarray/description">乘积最大子数组</a>
 */
public class T152 {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length + 1];
        int[] min = new int[nums.length + 1];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        max[0] = 1;
        min[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            max[i] = Math.max(nums[i - 1], Math.max(max[i - 1] * nums[i - 1], min[i - 1] * nums[i - 1]));
            min[i] = Math.min(nums[i - 1], Math.min(max[i - 1] * nums[i - 1], min[i - 1] * nums[i - 1]));
        }
        int res = max[1];
        for (int i = 1; i <= nums.length; i++) {
            res = Math.max(max[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T152().maxProduct(new int[]{-2,0,-1}));
    }
}
