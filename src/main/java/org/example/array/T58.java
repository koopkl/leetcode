package org.example.array;

/**
 * 最后一个单词的长度
 * 很简单
 * @Datetime: 2024/3/14 14:13
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/length-of-last-word/">最后一个单词的长度</a>
 */
public class T58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int wordEnd = end;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
        }
        return wordEnd - end;
    }

}
