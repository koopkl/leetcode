package org.example.array;

/**
 * 删除数组重复元素2
 * 那就多判断一次
 * @Datetime: 2024/2/27 17:18
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">
 *     删除数组重复元素2</a>
 */
public class T80 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            } else if ((index > 0 && nums[index - 1] != nums[i]) || index == 0) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
