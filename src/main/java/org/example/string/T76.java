package org.example.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 这里采用滑动窗口，先扩张窗口到包含t的字串，然后再缩小窗口，舍弃不必要的字符，得到最小的。
 * 优化速度的重点类似T438，T567，都是 **采用一个计数器来记录当前的还需要多少字符才能够满足**，当为0时即当前窗口满足条件
 * @Datetime: 2024/2/28 15:14
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/minimum-window-substring/description/">最小覆盖子串</a>
 */
public class T76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0;
        int count = t.length();
        int res = Integer.MAX_VALUE;
        int start = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (tMap.containsKey(c) && tMap.get(c) > 0) {
                count--;
            }
            tMap.put(c, tMap.getOrDefault(c, 0) - 1);
            if (count == 0) {
                char ci = s.charAt(i);
                while (i < j && tMap.get(ci) < 0) {
                    tMap.put(ci, tMap.get(ci) + 1);
                    i++;
                    ci = s.charAt(i);
                }
                if (j - i + 1 < res) {
                    res = j - i + 1;
                    start = i;
                }
                tMap.put(ci, tMap.getOrDefault(ci, 0) + 1);
                i++;
                count++;
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }

    public static void main(String[] args) {
        System.out.println(new T76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
