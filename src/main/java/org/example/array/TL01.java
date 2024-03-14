package org.example.array;

import java.util.Arrays;

/**
 * 自定义题目，题目如下：
 * 给定一个数组，长度为n，数组中的数字为[1,n]，统计数组中每一个数字出现的次数
 * 要求：使用空间O1，时间On的 方式
 * 题解：
 * 原地hash肯定都可以想到，但如何进行原地hash
 * 1 原地hash时，采用负数来记录一个数出现的次数
 * 2 原地hash时发现当前位置的数对应的hash的值已经出现过，即找不到下次的位置，此时应该将当前位置的值设置为0，这样下次可以更新位置。
 * @Datetime: 2024/3/14 14:01
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class TL01 {

    public void getCount(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int temp = nums[index] - 1;
            if (temp < 0) {
                index++;
                continue;
            }
            if (nums[temp] < 0) {
                nums[temp] --;
                nums[index] = 0;
            } else {
                nums[index] = nums[temp];
                nums[temp] = -1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new TL01().getCount(new int[]{4,1,3,4});
    }
}
