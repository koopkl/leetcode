package org.example.stack;

import java.util.Stack;

/**
 * 字符串解码
 * 注意嵌套时，需要将每次扩展后的结果也放到栈中，这点更类似于语法分析
 * @Datetime: 2024/2/3 20:46
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/decode-string/">字符串解码</a>
 */
public class T394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int temp = i;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                stack.push(s.substring(temp, i--));
            } else if (Character.isAlphabetic(c)) {
                stack.push(String.valueOf(c));
            } else if (c == '[') {
                stack.push(String.valueOf(c));
            } else if (c == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.empty() && !stack.peek().equals("[")) {
                    stringBuilder.append(stack.pop());
                }
                stack.pop();
                stack.push(stringBuilder.reverse().toString().repeat(Integer.parseInt(stack.pop())));
            }
        }
        while (!stack.empty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T394().decodeString("3[a2[c]]"));
    }
}
