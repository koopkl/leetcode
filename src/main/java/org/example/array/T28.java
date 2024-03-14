package org.example.array;

/**
 * 找出字符串中第一个匹配项的下标
 * @Datetime: 2024/3/11 21:41
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description">找出字符串中第一个匹配项的下标</a>
 */
public class T28 {
    public int strStr(String haystack, String needle) {
        int res = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return res;
    }
}
