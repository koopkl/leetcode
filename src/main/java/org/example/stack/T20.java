package org.example.stack;

import java.util.Stack;

/**
 * 有效的括号
 * @Datetime: 2024/1/30 19:30
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/valid-parentheses/description">有效的括号</a>
 */
public class T20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new T20().isValid("{}"));
        System.out.println(90.0 / 5);
    }
}
