package org.example.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集，输出一个数组的全部子集
 * @Datetime: 2024/2/26 14:44
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/subsets/">子集</a>
 */
public class T78 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    boolean[] bull = new boolean[11];
    public List<List<Integer>> subsets(int[] nums) {
        res.add(temp);
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, 0, i + 1);
            Arrays.fill(bull, false);
        }
        return res;
    }

    public void dfs(int[] nums, int index, int len) {
        if (index == len) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!bull[i]) {
                temp.add(nums[i]);
                bull[i] = true;
                dfs(nums, i + 1, len);
                temp.removeLast();
                bull[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new T78().subsets(new int[]{1,2,3}));
    }
}
