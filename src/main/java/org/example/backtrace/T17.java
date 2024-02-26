package org.example.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 理解上为多个集合的笛卡尔积
 * @Datetime: 2024/2/26 15:10
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">电话号码的字母组合</a>
 */
public class T17 {
    List<String> res = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    Map<Character, char[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        if (digits.isEmpty()) {
            return res;
        }
        dfs(digits, 0);
        return res;
    }
    public void dfs(String str, int index) {
        if (builder.length() == str.length()) {
            res.add(builder.toString());
            return;
        }
        for (int i = index; i < str.length(); i++) {
            for (char c : map.get(str.charAt(i))) {
                builder.append(c);
                dfs(str, i + 1);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new T17().letterCombinations("23"));
    }
}
