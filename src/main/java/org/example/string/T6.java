package org.example.string;

import java.util.Arrays;

/**
 * Z字形转换
 * 注意创建的stringbuilder数组
 * 注意巧妙的行索引直接得到最终结果
 * @Datetime: 2024/3/14 15:06
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/zigzag-conversion/">Z字形转换</a>
 */
public class T6 {
    public String convert(String s, int numRows) {
        int index = 0;
        int flag = 0;
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res[index].append(c);
            if (index == numRows - 1) {
                flag = 1;
            }
            if (index == 0) {
                flag = 0;
            }
            if (flag == 0) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : res) {
            result.append(row);
        }
        return result.toString();
    }
}
