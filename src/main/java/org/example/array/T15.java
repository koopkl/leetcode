package org.example.array;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 双重循环 + 双指针 和 双重循环+hash（困难）
 *
 * @Datetime: 7/1/2024 下午4:04
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/3sum/description/"> 三数之和</a>
 */
public class T15 {
    /**
     * 双重循环 + 双指针
     *
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                while (j > i + 1 && j < nums.length && nums[j - 1] == nums[j]) {
                    j++;
                }
                // 固定j，移动k
                while (j < k && -nums[i] - nums[j] - nums[k] < 0) {
                    k--;
                }
                if (j >= k) {
                    break;
                }
                if (-nums[i] - nums[j] - nums[k] == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    res.add(tempList);
                }
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T15().threeSum(new int[]{-0, 0, 0, 0}));
    }
}
