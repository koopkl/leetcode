package lsp.practice.meituan;

import java.util.Scanner;

/**
 * 美团面试 2024-03-16 第2题
 * @Datetime: 2024/3/17 13:43
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int count1 = 0;
        int count2 = 0;
        int count3 = str.length() + 1;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count1++;
            } else if (Character.isLowerCase(c)) {
                count2++;
            }
        }
        if (Character.isLowerCase(str.charAt(0))) {
            count3 = 1 + count1;
        } else {
            if (count1 > 1) {
                count3 = count1 - 1;
            }
        }
        System.out.println(Math.min(Math.min(count1, count2), count3));
    }
}
