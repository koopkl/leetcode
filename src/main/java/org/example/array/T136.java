package org.example.array;

/**
 * 只出现一次的数
 * 位运算
 * @Datetime: 2024/3/6 16:38
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/single-number/description/">只出现一次的数</a>
 */
public class T136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return  res;
    }
}
