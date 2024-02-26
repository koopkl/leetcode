package org.example.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 虽然很简单，但是要思考一下如何生成的括号，有点抽象，但事实上就是摆放左括号和右括号而已，无论什么顺序，主要当前的右括号比左括号多，总会匹配的
 * @Datetime: 2024/2/26 16:42
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/generate-parentheses/description/">括号生成</a>
 */
public class T22 {
    public List<String> res = new ArrayList<>();
    public StringBuilder builder = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(n, n);
        return res;
    }

    public void dfs(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            builder.append("(");
            dfs(left - 1, right);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right > 0) {
            builder.append(")");
            dfs(left, right - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T22().generateParenthesis(3));
    }
}
