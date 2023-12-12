package org.example.array;

/**
 * 在排序数组种查找元素的第一个和最后一个位置
 * 直觉理解上，搜索使用二分搜索两次，一次搜索应该插入的最左端，一次搜索应该插入的最右端。
 * 但关键是如何处理边界条件
 * 写法上，right初始化值一定要为nums.length - 1
 * 循环的边界条件，二分写法上，left<=right
 * 如何处理在每一次二分时，left和right的赋值？
 * 需要考虑两次搜索的关键不同点：当mid和target的值相同时，left与right应该如何移动
 * 对于插入的最左端，应该期待于right 更小，从而使剩余的搜索区间更偏向left移动
 * 对于插入的最右端，应该期待于left更大，从而使剩余的搜索区间更偏向于right移动。
 * @link <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/"> </a>
 */
public class T34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binaryLeft(nums, target), binaryRight(nums, target)};
    }

    public int binaryLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean flag = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                if (target == nums[mid]) {
                    flag = true;
                }
                right = mid - 1;
            }
        }
        if (!flag) {
            return -1;
        }
        return left;
    }

    public int binaryRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean flag = false;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                if (target == nums[mid]) {
                    flag = true;
                }
                left = mid + 1;
            }
        }
        if (!flag) {
            return -1;
        }
        return right;
    }
}
