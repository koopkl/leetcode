package org.example.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 很简单的找规律题目，这大概是最通俗易懂的动态规划题目
 * @Datetime: 2024/2/17 22:22
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/pascals-triangle/description">杨辉三角</a>
 */
public class T118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>(){{
            add(1);
        }};
        res.add(one);
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                List<Integer> last = res.getLast();
                int a = 0;
                int b = 0;
                if (j - 1 >= 0) {
                    a = last.get(j - 1);
                }
                if (j < last.size()) {
                    b = last.get(j);
                }
                temp.add(a + b);
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T118().generate(5));
    }
}
