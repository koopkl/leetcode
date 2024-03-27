package lsp.practice.meituan;

import java.util.Scanner;

/**
 * 美团面试 2024-03-16 第1题
 * @Datetime: 2024/3/17 13:43
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            sum += price;
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        sum = sum - x - y;
        System.out.println(sum);
    }
}
