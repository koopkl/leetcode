package org.example.array;

import java.util.*;

public class TM2024_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(n);
        System.out.println(k);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

    }

    public int getNumber(int[] nums, int k, int len) {
        Map<Integer, Integer> mapTwo = new HashMap<>();
        Map<Integer, Integer> mapFive = new HashMap<>();
        Map<Integer, Integer> zeroMap = new HashMap<>();
        Map<Integer, List<Integer>> zeroToSize = new HashMap<>();
        int mTwo = 0;
        int mFive = 0;
        for (int i = 0; i < len; i++) {
            int tempTwo = getFiveOrTwo(nums[i], 2);
            int tempFive = getFiveOrTwo(nums[i], 5);
            mapTwo.put(i, tempTwo);
            mapFive.put(i, tempFive);
            mTwo += tempTwo;
            mFive += tempFive;
            int count = Math.min(mTwo, mFive);
            zeroMap.put(i + 1, count);
            if (zeroToSize.containsKey(count)) {
                zeroToSize.get(count).add(i + 1);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(i + 1);
                zeroToSize.put(count, tempList);
            }
        }
        int m = Math.min(mTwo, mFive);
        int target = m - k;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (zeroMap.get(i + 1) > target) {
                int targetBefore = target - zeroMap.get(i + 1);
                if (zeroToSize.containsKey(targetBefore)) {
                    int tempRes = (i - zeroToSize.get(targetBefore).get(0));
                    res += (tempRes + 1) * tempRes / 2;
                }
            }
        }
        return res;
    }

    public int getFiveOrTwo(int num, int flag) {
        int res = 0;
        while (num > 0) {
           if (num % flag == 0) {
               res += 1;
               num = num / flag;
           } else {
               break;
           }
        }
        return res;
    }
}
