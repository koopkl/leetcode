package org.example.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            if (left == 0 && right - left + 1 <= k) {
                while (!deque.isEmpty() && nums[right] > deque.peekLast()) {
                    deque.removeLast();
                }
                if (right - left + 1 == k) {
                    left++;
                }
            } else {
                if (!deque.isEmpty() && deque.peekFirst() == nums[left - 1]) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && nums[right] > deque.peekLast()) {
                    deque.removeLast();
                }
                left++;
            }
            deque.add(nums[right]);
            if (left > 0 && right + 2 - left  >= k) {
                res[left - 1] = deque.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T239().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
