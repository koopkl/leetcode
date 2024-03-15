package org.example.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 有效的字母异位词
 * 就是喜欢用流式处理，真的帅
 * @Datetime: 2024/3/15 14:14
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/valid-anagram/description/">有效的字母异位词</a>
 */
public class T242 {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Long> collectS = s.codePoints().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Integer, Long> collectT = s.codePoints().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        if (collectS.size() != collectT.size()) {
            return false;
        }
        System.out.println(collectS);
        System.out.println(collectT);
        for (Integer key: collectS.keySet()) {
            if (!collectT.containsKey(key)) {
                return false;
            }
            if (collectS.get(key).longValue() != collectT.get(key).longValue()) {
                return false;
            }
        }
        return true;
    }
}
