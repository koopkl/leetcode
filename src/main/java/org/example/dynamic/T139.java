package org.example.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 单词拆分
 * 这里采用的记忆化搜索，使用递归方式来处理
 * 也可以针对字符串的每一个字符使用动态规划
 * @Datetime: 2024/2/21 22:17
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/word-break">单词拆分</a>
 */
public class T139 {

    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }

    public boolean dfs(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.isEmpty()) {
            return true;
        }
        boolean flag = false;
        for (String temp : wordDict) {
           if (s.startsWith(temp)) {
               flag = dfs(s.substring(temp.length()), wordDict);
               if (flag) {
                   map.putIfAbsent(s, flag);
                   return flag;
               }
           }
        }
        map.putIfAbsent(s, flag);
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new T139().wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }
}
