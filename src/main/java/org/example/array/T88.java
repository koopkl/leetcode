package org.example.array;

/**
 * 合并两个有序数组
 * 正着不行 咱反着
 * @Datetime: 2024/2/27 16:54
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/merge-sorted-array/">合并两个有序数组</a>
 */
public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1 = m - 1;
        int n2 = n - 1;
        int index = n + m - 1;
        while (n1 >= 0 && n2 >= 0) {
            if (nums2[n2] > nums1[n1]) {
                nums1[index--] = nums2[n2--];
            } else {
                nums1[index--] = nums1[n1--];
            }
        }
        while (n2 >= 0) {
            nums1[index--] = nums2[n2--];
        }
        while (n1 >= 0) {
            nums1[index--] = nums2[n1--];
        }

    }
}
