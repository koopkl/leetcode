package org.example.array;

import java.io.Externalizable;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 反转字符串中的单词
 * 注意下最终的builder会多一个空格
 * @Datetime: 2024/3/14 14:18
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">反转字符串中的单词</a>
 */
public class T151  {
    public String reverseWords(String s) {

        StringBuilder builder = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            StringBuilder tempBuilder = new StringBuilder();
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }
            while (end >= 0 && s.charAt(end) != ' ') {
                tempBuilder.append(s.charAt(end));
                end--;
            }
            if (!tempBuilder.isEmpty()) {
                builder.append(tempBuilder.reverse());
                builder.append(" ");
            }
        }
        return builder.substring(0, builder.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new T151().reverseWords(" hello world "));
    }
}
