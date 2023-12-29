package org.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 水果成篮子
 * 很典型的双指针问题，但是不知道为什么，我的双指针总是需要判断各种边界条件
 * 导致每次写双指针会花费较多时间在边界条件判断上。
 * updated
 * @link <a href="https://leetcode.cn/problems/fruit-into-baskets/description/"> </a>
 */

/**
 * Description:
 * Datetime: 15/12/2023 下午4:08
 * Link: <a href=""> </a> */
public class T904 {
    public int totalFruit(int[] fruits) {
        int j = 0;
        int i = 0;
        int nowMax = -1;
        int nowBegin = -1;
        int nowSecond = -1;
        while (i < fruits.length && j < fruits.length) {
            nowBegin = fruits[i];
            int count = 0;
            while (i < fruits.length && fruits[i] == nowBegin) {
                i++;
                count++;
            }
            if (i < fruits.length) {
                nowSecond = fruits[i];
            } else {
                nowMax = Math.max(nowMax, count);
                continue;
            }
            j = i + 1;
            while (j < fruits.length && (fruits[j] == nowBegin || fruits[j] == nowSecond)) {
                j++;
            }
            nowMax = Math.max(nowMax, Math.min(j, fruits.length) - i + count);
        }
        return nowMax;
    }
}
