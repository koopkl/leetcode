package org.example.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 滑动窗口
 * @Datetime: 16/1/2024 下午4:58
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">无重复字符的最长子串</a>
 */
public class T3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            if (set.size() > res) {
                res = set.size();
            }
            if (j == s.length()) {
                break;
            }
            set.remove(s.charAt(i));
            i += 1;
        }
        return res;
    }
}
