package org.example.string;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 * 数组应该更快，但是我喜欢Map，🤭
 * map的初始化太麻烦
 * 这道题相当经典的滑动窗口，通过额外的计数器来对比map，查看是否匹配
 * 滑动窗口题目两个要点：窗口何时移动？窗口移动后会产生何种影响？
 * @Datetime: 16/1/2024 下午8:39
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string">找到字符串中所有字母异位词</a>
 */
public class T438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapP = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            mapP.put((char) ('a' + i), 0);
            mapS.put((char) ('a' + i), 0);
        }
        for (int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.get(p.charAt(i)) + 1);
            mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
        }
        int diff = 0;
        for (Character c : mapP.keySet()) {
            if (!mapS.get(c).equals(mapP.get(c))) {
                diff++;
            }
        }
        if (diff == 0) {
            res.add(0);
        }
        int j = p.length();
        for (int i = 1; i < s.length() - p.length() + 1 && j < s.length(); i++) {
            if (mapS.get(s.charAt(i - 1)) - 1 == mapP.get(s.charAt(i - 1))) {
                diff--;
            } else if (mapS.get(s.charAt(i - 1)).equals(mapP.get(s.charAt(i - 1)))) {
                diff++;
            }
            mapS.put(s.charAt(i - 1), mapS.get(s.charAt(i - 1)) - 1);
            if (mapS.get(s.charAt(j)) + 1 == mapP.get(s.charAt(j))) {
                diff--;
            } else if (mapS.get(s.charAt(j)).equals(mapP.get(s.charAt(j)))) {
                diff++;
            }
            mapS.put(s.charAt(j), mapS.get(s.charAt(j)) + 1);
            j++;
            if (diff == 0) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T438().findAnagrams("abab", "ab"));
    }
}
