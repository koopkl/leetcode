package org.example.stack;

import java.util.Stack;

/**
 * 最小栈
 * 双栈 + 单栈差值法
 * @Datetime: 2024/1/31 22:36
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/min-stack/description/">最小栈</a>
 */
public class T155 {
    class MinStack {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();
        public MinStack() {
            stackMin.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack1.push(val);
            stackMin.push(Math.min(stackMin.peek(), val));
        }
        public void pop() {
            stackMin.pop();
            stack1.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stackMin.peek();
        }
    }

    class MinStack2 {

        private Stack<Long> stack1 = new Stack<>();
        long min = Long.MAX_VALUE;
        public MinStack2() {

        }

        public void push(int val) {
            if (stack1.empty()) {
                stack1.push(0L);
                min = val;
            } else {
                stack1.push((val - min));
                min = Math.min(val, min);
            }

        }
        public void pop() {
            long diff = stack1.pop();
            if (diff < 0) {
                min = min - diff;
            }
        }

        public int top() {
            return (int) (min + Math.max(0, stack1.peek()));
        }

        public int getMin() {
            return (int) min;
        }
    }
}
