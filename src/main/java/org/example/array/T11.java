package org.example.array;

/**
 * 双指针，贪心寻找最大值
 * @Datetime: 5/1/2024 下午4:12
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/container-with-most-water/description/"> 盛水最多的容器</a>
 */
public class T11 {
    public int maxArea(int[] height) {
        int len = height.length;
        int max = -1;
        for (int i = 0, j = len - 1; i <= j;) {
            int left = height[i];
            int right = height[j];
            int tempRes = (j - i);
            if (left < right) {
                i++;
                tempRes *= left;
            } else {
                j--;
                tempRes *= right;
            }
            max = Math.max(max, tempRes);
        }
        return max;
    }
}
