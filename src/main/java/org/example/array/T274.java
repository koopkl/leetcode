package org.example.array;

import java.util.Arrays;

/**
 * H指数
 * 排序+遍历
 * @Datetime: 2024/3/7 18:38
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/h-index/description/">H指数</a>
 */
public class T274 {
    public int hIndex(int[] citations) {
        Integer[] array = Arrays.stream(citations).boxed().sorted((o1, o2) -> o2 - o1).toArray(Integer[]::new);
        for (int j = 1; j <= citations.length; j++) {
            if (array[j - 1] < j) {
                return j - 1;
            }
        }
        return array.length;
    }
}
