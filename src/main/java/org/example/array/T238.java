package org.example.array;

import java.util.Arrays;

/**
 * 除自身以外数组的乘积
 * @Datetime: 2024/3/7 22:02
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/product-of-array-except-self/description/">除自身以外数组的乘积</a>
 */
public class T238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[nums.length + 1];
        int[] right = new int[nums.length + 1];
        left[0] = 1;
        right[0] = 1;
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            left[i + 1] = left[i] * nums[i];
            right[i + 1] = right[i] * nums[j];
        }
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = left[i] * right[len - i - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T238().productExceptSelf(new int[]{1,2,3,4})));
    }
}
