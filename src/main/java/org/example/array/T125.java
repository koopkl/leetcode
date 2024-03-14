package org.example.array;

/**
 * 验证回文串
 * 重点为包括了数字和字母，使用isLetterOrDigit方法
 * 采用O1时，须记得while循环条件始终为i < j，如果在找另外一头的时候，出现了i >= j的情况，那么代表已经查找结束了，
 * 这是因为每次在while前都保证了上次查询结果一定是一个回文串，下次找不到对应的字符，那就说明已经结束了。
 * @Datetime: 2024/3/14 14:14
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/valid-palindrome/">验证回文串</a>
 */
public class T125 {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i <j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i < j ) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T125().isPalindrome(" "));
    }
}
