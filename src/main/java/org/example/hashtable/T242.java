package org.example.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @Datetime: 3/1/2024 下午3:24
 * @Author: koopkl
 * @Link: <a href=""></a>
 */
public class T242 {
    public boolean isAnagram(String s, String t) {
        Map<String, Long> collectS = s.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<String, Long> collectT = t.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        if (collectS.size() != collectT.size()) {
            return false;
        }
        for (String key: collectS.keySet()) {
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
