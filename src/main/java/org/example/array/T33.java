package org.example.array;

/**
 * 搜索旋转排序数组
 * 在一个不那么有顺序的数组中使用二分搜索，但是这个数组可以被分为两部分，每一部分都是有序的
 * 在进行二分时，每一次二分后得到的数组，都是类似原数组，可以分为两部分，每一部分都是有序的
 * @Datetime: 2024/1/30 18:59
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/description">搜索旋转排序数组</a>
 */
public class T33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < mid) {
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
