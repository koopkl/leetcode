package org.example.array;

/**
 * 最长公共前缀
 * @Datetime: 2024/3/14 14:07
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/longest-common-prefix/"></a>
 */
public class T14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String  str1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            while (index <  Math.min(str1.length(), strs[i].length()) && str1.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            str1 = str1.substring(0, index);
            if (index == 0) {
                break;
            }
        }
        return str1;
    }
}
