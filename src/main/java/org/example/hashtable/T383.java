package org.example.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 *
 * @Datetime: 3/1/2024 下午3:24
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/ransom-note/"> 赎金信</a>
 */
public class T383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.computeIfPresent(c, (i, j) -> j - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
