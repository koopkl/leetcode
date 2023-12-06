package org.example.array;

/**
 * 二分查找
 * @link <a href="https://leetcode.cn/problems/binary-search/description/">T704</a>
 */
public class T704 {
    public int search(int[] nums, int target) {
        return bindSearch(nums, 0, nums.length -1, target);
    }

    /**
     * 二分查找的递归写法
     */
    public int bindSearch(int[] nums, int begin, int end, int target) {
        System.out.println(begin);
        System.out.println(end);
        if (begin >= end) {
            return nums[begin] >= target ? begin : -1;
        }
        int middle = (begin + end) / 2;
        if (target > nums[middle]) {
            return bindSearch(nums, middle + 1, end, target);
        }
        if (target < nums[middle]) {
            return bindSearch(nums, begin, middle, target);
        }
        return middle;
    }

    /**
     * 二分查找的循环写法

     * @return
     */
    public int bindSearchLoop(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public void test() {
        int[] a = new int[]{5,6,8,20};
        System.out.println(search(a, 20));
    }
}
