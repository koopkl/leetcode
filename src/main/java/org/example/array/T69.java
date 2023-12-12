package org.example.array;

/**
 * x的平方根
 * todo 二分
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
}
