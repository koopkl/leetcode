package org.example.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 前k个高频元素
 * hash + PriorityQueue
 * @Datetime: 2024/2/16 15:31
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/top-k-frequent-elements/description">前k个高频元素</a>
 */
public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length + 1);
        int[] res = new int[k];
        for (int num: nums) {
            map.putIfAbsent(num, 0);
            map.computeIfPresent(num, (key, value) -> value + 1);
        }
//        System.out.println(map);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        new T347().topKFrequent(new int[]{1,2,3,4,4,4,4}, 3);
    }
}
