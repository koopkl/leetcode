package org.example.array;

/**
 * x的平方根
 * @link <a href="https://leetcode.cn/problems/sqrtx/"> </a>
 */
public class T69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        for (int i = 0; i <= x / 2 + 1; i++) {
            long s = ((long) i) * ((long)i);
            if (s == x) {
                return i;
            } else if (s > x) {
                return i - 1;
            }
        }
        return -1;
    }

    public int binarySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
