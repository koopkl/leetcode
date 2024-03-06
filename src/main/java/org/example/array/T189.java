package org.example.array;

import java.util.Arrays;

/**
 * 轮转数组
 * 轮转数组，但是O(1)
 * @Datetime: 2024/3/6 16:36
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/rotate-array/description/">轮转数组</a>
 */
public class T189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        k = k % len;
        while (count < gcd(k, len)) {
            int index = count;
            int temp = nums[index];
            do {
                int newIndex = (index + k) % len;
                int oldTemp = temp;
                temp = nums[newIndex];
                nums[newIndex] = oldTemp;
                index = newIndex;
            } while (count != index);
            count++;
        }
    }
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
       new T189().rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
