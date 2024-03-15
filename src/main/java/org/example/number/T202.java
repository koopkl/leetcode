package org.example.number;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * @Datetime: 2024/3/15 15:10
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/happy-number/description/">快乐数</a>
 */
public class T202 {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<>();
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1 ;
    }

    public int getNext(int n) {
        int temp = n;
        int sum = 0;
        while (temp > 0) {
            sum += (temp % 10) * (temp % 10);
            temp /= 10;
        }
        return sum;
    }
}

