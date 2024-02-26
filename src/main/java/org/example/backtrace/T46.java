package org.example.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 直觉上很难，写出来很简单其实，大胆回溯
 * @Datetime: 2024/2/24 17:08
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/permutations/description">全排列</a>
 */
public class T46 {
    public boolean[] bull = new boolean[7];
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int count) {
        if (count == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!bull[i]) {
                temp.add(nums[i]);
                bull[i] = true;
                dfs(nums, count + 1);
                temp.removeLast();
                bull[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new T46().permute(new int[]{1,2,3}));
    }
}
