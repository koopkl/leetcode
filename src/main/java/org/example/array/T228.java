package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 * @Datetime: 2024/3/15 16:06
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/summary-ranges/description/">汇总区间</a>
 */
public class T228 {
    public List<String> summaryRanges(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return new ArrayList<String>();
        }
        StringBuilder temp = new StringBuilder();
        temp.append(nums[0]);
        int index = 0;
        List<String> resStr = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (i - index > 1) {
                    temp.append("->");
                    temp.append(nums[i - 1]);
                }
                index = i;
                resStr.add(temp.toString());
                temp = new StringBuilder();
                temp.append(nums[i]);
            }
        }
        if (nums.length - index > 1) {
            temp.append("->");
            temp.append(nums[nums.length - 1]);
        }
        resStr.add(temp.toString());
        return resStr;
    }

    public static void main(String[] args) {
        System.out.println(new T228().summaryRanges(new int[]{0,1,2,4,6,7}));
    }
}
