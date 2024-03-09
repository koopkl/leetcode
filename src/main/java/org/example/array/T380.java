package org.example.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * O1 时间内插入、删除
 * @Datetime: 2024/3/7 21:47
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/insert-delete-getrandom-o1/"></a>
 */
public class T380 {
    static class RandomizedSet {

        Map<Integer, Integer> map = new HashMap<>();

        int[] num = new int[2 * 100000 + 50];
        int end;
        Random random = new Random();
        public RandomizedSet() {
            int end = 0;
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, end);
            num[end] = val;
            end++;
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int remove = map.remove(val);
            num[remove] = num[end - 1];
            if (remove != end - 1) {
                map.put(num[end - 1], remove);
            }
            end--;
            return true;
        }

        public int getRandom() {
            int a = random.nextInt(0, end);
            return num[a];
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.getRandom();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.insert(2);
    }

}
