package org.example.array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Datetime: 5/1/2024 下午3:17
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/">最长连续序列</a>
 */
public class T128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }
        int res = 0;
        for (Integer num : set) {
            int tempRes = 1;
            if (!set.contains(num - 1)) {
                int nowNum = num;
                while (set.contains(nowNum + 1)) {
                    nowNum += 1;
                    tempRes += 1;
                }
            }
            res = Math.max(res, tempRes);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T128().longestConsecutive(new int[]{100, 1, 2, 3, 200}));
    }
}
