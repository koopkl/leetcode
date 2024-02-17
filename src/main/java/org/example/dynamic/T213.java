package org.example.dynamic;

/**
 * 打家劫舍2
 * @Datetime: 2024/2/17 22:39
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/house-robber-ii/description/">打家劫舍2</a>
 */
public class T213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(myRob(nums, 0, nums.length - 2), myRob(nums, 1, nums.length - 1));
    }

    public int myRob(int[] nums, int start, int end) {
        int len = end - start + 1;
        int[] res = new int[len + 1];
        res[0] = 0;
        res[1] = nums[start];
        for (int i = start + 2; i <= start + len; i++) {
            res[i - start] = Math.max(res[i - 2 - start] + nums[i - 1], res[i - 1 - start]);
        }
        return res[len];
    }

    public static void main(String[] args) {
        System.out.println(new T213().rob(new int[]{1,2,1,1}));
    }
}
