package org.example.array;

/**
 * x的平方根
 * @link <a href="https://leetcode.cn/problems/search-insert-position/description/">T35</a>
 */
public class T35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
