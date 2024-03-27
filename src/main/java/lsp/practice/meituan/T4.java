package lsp.practice.meituan;

import java.util.Scanner;

/**
 * 美团面试 2024-03-16 第4题
 * @Datetime: 2024/3/17 13:45
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt() - 1;
        }
        long res = 0;
        int[] sumArray = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sumArray[i + 1] = sumArray[i] + nums[i];
        }
        for (int i = 1; i <= n; i++) {
            int sum = sumArray[i];
            if (sum > i / 2 ) {
                res += 1;
            }
            for (int j = 1; j <= n - i; j++) {
                sum -= nums[j - 1];
                sum += nums[j + i - 1];
                if (sum > i / 2) {
                    res += 1;
                }
            }
        }
        res += ((long) n * (n + 1)) / 2;
        System.out.println(res);
    }
}
