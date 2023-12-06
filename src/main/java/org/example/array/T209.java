package org.example.array;

import java.util.Arrays;

/**
 * 长度最小的子数组，这个滑动窗口做法有点
 * @link <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/"> </a>
 */
public class T209 {
    /**
     * 滑动窗口方法实现，但是这个方法有点反直觉，是在硬凑前缀和
     * 具体思路为针对首先求出前缀和，这里前缀和第一个数为0，代表0个数组元素的和为0
     * 接下来i比j慢，首先固定i，j向前查找，直到找到一个sum[j]-sum[i] >= target
     * 若找到，记下此时的区间长度j-i作为min，接下来i前进一步，此时若仍然有sum[j] - sum[i] >= target，表示区间缩小，但是和仍然大于target，
     * 那么此时更新区间最短长度为新的j-i，如此循环，若某一次缩小区间，导致不存在sum[j] - sum[i] >= target，则前进j,找到下一个区间
     * 右端，直到j为前缀和的最后，且j此时区间和仍然不满足大于target，则结束
     * @return 和>= target的最小连续子数组区间的长度
     */
     public int minSubArrayLen(int target, int[] nums) {
         int[] sum = new int[nums.length + 1];
         sum[0] = 0;
         for (int i = 0; i < nums.length; i++) {
             sum[ i + 1] = sum[i] + nums[i];
         }
         int nowMin = nums.length + 3;
         for (int i = 0, j = 1; i < sum.length; i++) {
             if (sum[j] - sum[i] < target) {
                 while (j < sum.length && sum[j] - sum[i] < target) {
                     j++;
                 }
             }
             if (j >= sum.length && sum[j - 1] - sum[i] < target) {
                 break;
             }
             nowMin = Math.min(nowMin, j - i);
         }
         return nowMin == nums.length + 3 ? 0 : nowMin;
     }

    /**
     * 前缀和+二分
     */
    public int sumAndBinarySearch(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[ i + 1] = sum[i] + nums[i];
        }
        int res = nums.length + 5;
        for (int i = 0; i < sum.length; i++) {
            int temp = sum[i] + target;
//            int bound1 = bindSearch(nums, 0, nums.length -1, temp);
            int bound = Arrays.binarySearch(sum, target);

            if (bound < 0) {
                bound = -bound - 1;
            }
            System.out.println(bound);
            if (bound <= nums.length) {
                res = Math.min(res, bound - i);
            }
        }
        return res == nums.length + 5 ? 0 : res;
    }

    public int bindSearch(int[] nums, int begin, int end, int target) {
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

}
