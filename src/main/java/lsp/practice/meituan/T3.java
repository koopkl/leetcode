package lsp.practice.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 美团面试 2024-03-16 第3题
 * @Datetime: 2024/3/17 13:43
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ops = new int[q];
        for (int i = 0; i < q; i++) {
            ops[i] = scanner.nextInt();
        }
        System.out.println(operate(nums, ops, n, q));
    }

    public static long operate(int[] nums, int[] ops, int n, int q) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int op : ops) {
            map.put(op - 1, map.getOrDefault(op - 1, 0) + 1);
        }
        long sum = 0;
        int modSum = (int)(Math.pow(10, 9) + 7);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(i)) {
                sum += (mod(q - map.get(i), modSum) * num) % modSum;
            } else {
                sum += ((mod(q, modSum)) * num )% modSum;
            }
            sum = sum % modSum;
        }
        return sum;
    }

    public static long mod(int k, int modNum) {
        long temp = 2 % modNum;
        long res = 1;
        while (k > 0) {
            if ((k % 2) == 1) {
                res = (res * temp) % modNum;
            }
            temp = (temp * temp) % modNum;
            k = k / 2;
        }
        return res;
    }
}
