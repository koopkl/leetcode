package org.example.string;

/**
 * 字符串排列
 * 和 T438 很类似，基本一致
 * @Datetime: 2024/2/28 15:13
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/permutation-in-string/description/">字符串排列</a>
 */
public class T567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] mapS1 = new int[26];
        int[] mapS2 = new int[26];
        for (int i = 0; i < len; i++) {
            mapS1[s1.charAt(i) - 'a']++;
            mapS2[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < mapS1.length; i++) {
            if (mapS1[i] != mapS2[i]) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = 1; i < s2.length() - len + 1; i++) {
            int index = s2.charAt(i - 1) - 'a';
            if (mapS2[index] - 1 == mapS1[index]) {
                diff--;
            } else if (mapS2[index] == mapS1[index]) {
                diff++;
            }
            mapS2[s2.charAt(i - 1) - 'a']--;
            int j = i + len - 1;
            index = s2.charAt(j) - 'a';
            if (mapS2[index] == mapS1[index]) {
                diff++;
            } else if (mapS2[index] + 1 == mapS1[index]) {
                diff--;
            }
            mapS2[index]++;
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T567().checkInclusion("adc", "dcda"));
    }
}
