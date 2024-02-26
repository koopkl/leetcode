package org.example.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * 回溯题目只需要将树想出来，然后剪枝和暴力即可
 * 这里回文字串应该可以被优化，提前算出来，这样不用每次都去遍历搜索了（对应leetcode T5 最长回文子串）
 * 采用二维动态规划
 * @Datetime: 2024/2/26 19:08
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/palindrome-partitioning/description">分割回文串</a>
 */
public class T131 {

    public List<List<String>> res = new ArrayList<>();

    public List<String> temp = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s);
        return res;
    }

    public void dfs(String s) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isPalindrome(str)) {
                temp.add(str);
                dfs(s.substring(i));
                temp.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int len = s.length() / 2;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T131().partition("aabab"));
    }
}
