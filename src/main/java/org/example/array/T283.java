package org.example.array;

import java.util.Arrays;

/**
 * 移动零
 * @link <a href="https://leetcode.cn/problems/move-zeroes/description/"> </a>
 */
public class T283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=  0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index += 1;
            }
        }
    }
}
