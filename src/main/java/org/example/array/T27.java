package org.example.array;

/**
 * 移除元素
 * @link <a href=https://leetcode.cn/problems/remove-element/description/>T27</a>
 */
public class T27 {
    /**
     * 双指针方法

     * @return
     */
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index += 1;
            }
        }
        return index;
    }
}
