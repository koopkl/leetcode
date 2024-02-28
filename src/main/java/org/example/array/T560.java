package org.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 * 前缀和要和hash表一起用
 * @Datetime: 2024/2/28 11:42
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/subarray-sum-equals-k/">和为k的子数组</a>
 */
public class T560 {
    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 1);
        for (int num : nums) {
            pre = pre + num;
            res += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T560().subarraySum(new int[]{1,1,1}, 2));
    }
}
