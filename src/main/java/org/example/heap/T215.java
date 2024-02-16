package org.example.heap;

import java.util.PriorityQueue;

/**
 * 第k大元素
 * TopK，最小堆
 * MinK，最大堆
 * @Datetime: 2024/2/16 15:32
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array">第k大元素</a>
 */
public class T215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
