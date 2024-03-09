package org.example.string;

import java.util.Stack;

public class T150 {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int a1 = stack.pop();
                    int b1 = stack.pop();
                    stack.push(b1 - a1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
