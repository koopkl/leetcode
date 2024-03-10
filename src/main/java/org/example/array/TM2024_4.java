package org.example.array;

import java.util.*;

public class TM2024_4 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        System.out.println(n);
//        System.out.println(k);
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
        System.out.println(new TM2024_4().getNumber(new int[]{2, 5, 3, 4, 20}, 2, 5));
    }

    public int getNumber(int[] nums, int k, int len) {
        Map<Integer, Integer> mapTwo = new HashMap<>();
        Map<Integer, Integer> mapFive = new HashMap<>();
        Map<Integer, Integer> zeroMap = new HashMap<>();
        zeroMap.put(0, 0);
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
        }
        int m = Math.min(mTwo, mFive);
        int target = m - k;
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
           if (zeroMap.get(j + 1) - zeroMap.get(i) > target) {
               i++;
               j++;
               continue;
           }
           while (j < len && zeroMap.get(j + 1) - zeroMap.get(i) <= target) {
               j++;
           }
           res += (j - i) * (j - i + 1) / 2;
           i = j;
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