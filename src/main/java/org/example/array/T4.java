package org.example.array;

/**
 * 查找两个有序数组的中位数
 * @Datetime: 2024/3/27 18:12
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/description/">查找两个有序数组的中位数</a>
 */
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double res = 0;
        if ((m + n) % 2 == 0) {
            res = (getNums(nums1, nums2, (m + n) / 2) + getNums(nums1, nums2, (m + n) / 2 + 1)) / 2.0;
        } else {
            res = getNums(nums1, nums2, (m + n) / 2 + 1);
        }
        return res;
    }
    public int getNums(int[] nums1, int[] nums2, int k) {
        int right1 = nums1.length;
        int right2 = nums2.length;
        int left1 = 0;
        int left2 = 0;
        while (true) {
            if (left1 >= right1) {
                return nums2[left2 + k - 1];
            }
            if (left2 >= right2) {
                return nums1[left1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[left1], nums2[left2]);
            }
            int mid = k / 2;
            int temp1K = Math.min(left1 + mid, right1) - 1;
            int temp2K = Math.min(left2 + mid, right2) - 1;
            if (nums1[temp1K] <= nums2[temp2K]) {
                k -= (temp1K - left1 + 1);
                left1 = temp1K + 1;
            } else {
                k -= (temp2K - left2 + 1);
                left2 = temp2K + 1;
            }
        }
    }
}
