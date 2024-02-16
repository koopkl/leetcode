package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 每日温度
 * 使用双端队列来模拟栈要比Stack快很多很多，Stack是线程安全的，但是双端队列并不线程安全
 * @Datetime: 2024/2/3 20:47
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/daily-temperatures/">每日温度</a>
 */
public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<Integer>(); //单调递减的栈
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int peek = stack.pop();
                res[peek] = i - peek;
            }
            stack.push(i);
        }
        return res;
    }
}
