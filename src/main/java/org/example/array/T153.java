package org.example.array;

/**
 * 和 T33类似，但是对于无序的一边进行搜索，有序的一边可以直接得到最小值
 * @Datetime: 2024/1/30 19:15
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/">
 *     寻找旋转数组中的最小值</a>
 */
public class T153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                if (nums[left] < min) {
                    min = nums[left];
                }
                left = mid + 1;
            } else {
                if (nums[mid] < min) {
                    min = nums[mid];
                }
                right = mid - 1;
            }
        }
        return min;
    }
}
