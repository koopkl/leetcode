package org.example.dynamic;

/**
 * 最大子数组之和
 * @Datetime: 2024/2/22 16:22
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/maximum-subarray/">最大子数组之和</a>
 */
public class T53 {
    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length + 1];
        res[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            res[i] = Math.max(res[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(res[i], max);
        }
//        int max = res[1];
//        for (int i = 1; i <= nums.length; i++) {
//            max = Math.max(res[i], max);
//        }
        return max;
    }
}
