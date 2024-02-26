package org.example.backtrace;

import org.example.array.T209;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * 很类似三数之和，这里的剪枝
 * @Datetime: 2024/2/26 16:19
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/combination-sum/description/">组合总和</a>
 */
public class T39 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                temp.add(candidates[i]);
                dfs(candidates, target - candidates[i], i);
                temp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new T39().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
