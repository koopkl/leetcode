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
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            } else if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new T80().removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
