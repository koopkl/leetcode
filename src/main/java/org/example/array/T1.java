package org.example.array;
import java.util.*;

/**
 * 两数之和
 */
public class T1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])) {
                return new int[]{temp.get(target - nums[i]), i};
            }
            temp.put(nums[i], i);
        }
        return new int[0];
    }
}
