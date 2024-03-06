package org.example.array;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 * @Datetime: 2024/2/27 17:10
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/">
 *     删除有序数组中的重复项</a>
 */
public class T26 {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new T26().removeDuplicates(new int[]{1,1,2}));
    }
}
