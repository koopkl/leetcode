package org.example.array;

/**
 * 有效的完全平方数
 * @link <a href="https://leetcode.cn/problems/valid-perfect-square/description/"> </a>
 */
public class T367 {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long res = (long) mid * mid;
            if (res > num) {
                right = mid - 1;
            } else if (res == num) {
                return true;
            } else {
                left = mid + 1;
            }
        }
        return  false;
    }
}
