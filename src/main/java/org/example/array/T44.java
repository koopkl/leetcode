package org.example.array;


import java.util.Queue;

/**
 * 通配符匹配
 * @Datetime: 2024/3/27 18:14
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/wildcard-matching/description/">通配符匹配</a>
 */
public class T44  {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] res = new boolean[len1 + 1][len2 + 1];
        res[0][0] = true;
        for (int i = 1; i < len1; i++) {
            if (p.charAt(i - 1) == '*') {
                res[0][i + 1] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (p.charAt(j) == '*') {
                    res[i + 1][j + 1] = res[i][j + 1] | res[i + 1][j];
                } else if (p.charAt(j) == '?') {
                    res[i + 1][j + 1] = res[i][j];
                } else if (p.charAt(j) == p.charAt(i)) {
                    res[i + 1][j + 1] = res[i][j];
                } else {
                    return false;
                }
            }
        }
        return res[len1][len2];
    }
}
