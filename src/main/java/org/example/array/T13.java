package org.example.array;

import java.util.HashMap;

/**
 * 罗马字符，没啥东西
 * @Datetime: 2024/3/15 16:07
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T13 {
    public int romanToInt(String s) {
        HashMap<Integer, Integer> res1 = new HashMap<>();

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i++;
                } else {
                    res += 1;
                }
            }
            if (c == 'V') {
                res += 5;
            }
            if (c == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i++;
                } else {
                    res += 10;
                }
            }
            if (c == 'L') {
                res += 50;
            }
            if (c == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i++;
                } else {
                    res += 100;
                }
            }
            if (c == 'D') {
                res += 500;
            }
            if (c == 'M') {
                res += 1000;
            }
        }
        return res;
    }
}
