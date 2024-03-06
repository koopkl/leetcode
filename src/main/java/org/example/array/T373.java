package org.example.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 查找和最小的 K 对数字
 * K对数字,其实是多路归并排序。
 * 多路归并排序，这里只需要得到其中前k个
 * @Datetime: 2024/3/5 17:03
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/">查找和最小的 K 对数字</a>
 *
 */

public class T373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a1, a2) -> nums1[a1.get(0)] + nums2[a1.get(1)] - nums1[a2.get(0)]- nums2[a2.get(1)]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(0);
            queue.add(temp);
        }
        while (res.size() < k && !queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[poll.get(0)]);
            temp.add(nums2[poll.get(1)]);
            res.add(temp);
            if (poll.get(1) < nums2.length - 1) {
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(poll.get(0));
                temp1.add(poll.get(1) + 1);
                queue.add(temp1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T373().kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 3);
    }
}
