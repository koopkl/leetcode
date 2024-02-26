package org.example.dynamic;

/**
 * 最长回文子串
 * @Datetime: 2024/2/26 19:17
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/longest-palindromic-substring/">最长回文字串</a>
 */
public class T5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = true;
        }
        int maxBegin = 0;
        int maxEnd = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || res[j + 1][i - 1])) {
                    res[j][i] = true;
                    if (i - j + 1 > (maxEnd - maxBegin + 1)) {
                        maxBegin = j;
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxBegin, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(new T5().longestPalindrome("babad"));
    }

}
