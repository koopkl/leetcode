package org.example.array;

import java.util.Arrays;


/**
 * 有序数组的平方。
 * 非递减顺序，指后一个数不会比前一个数小
 * @link <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/description/">T977</a>
 */
public class T977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int i = 0;
        int j = nums.length - 1;
        while (index >=  0) {
            int squareI = nums[i] * nums[i];
            int squareJ = nums[j] * nums[j];
            if (squareJ > squareI) {
                res[index] = squareJ ;
                j -= 1;
            } else {
                res[index] = squareI;
                i += 1;
            }
            index -= 1;
        }
        return res;
    }
}
