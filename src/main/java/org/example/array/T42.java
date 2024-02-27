package org.example.array;

/**
 * 接雨水
 * 难的哦
 * 思考到一根柱子上的水和什么有关，那么问题便迎刃而解
 * @Datetime: 7/1/2024 下午9:16
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/trapping-rain-water/description/">接雨水</a>
 */
public class T42 {
    public int trap(int[] height) {
        int sum = 0;
        int[] resLeft = new int[height.length];
        int[] resRight = new int[height.length];
        for (int i = 1, j = height.length - 2; i < height.length && j >= 0; i++, j--) {
            resLeft[i] = Math.max(resLeft[i - 1], height[i - 1]);
            resRight[j] = Math.max(resRight[j + 1], height[j + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            int val = Math.min(resLeft[i], resRight[i]) - height[i];
            if (val > 0) {
                sum += val;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T42().trap(new int[]{4,2,0,3,2,5}));
    }
}
