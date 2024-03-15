package org.example.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的字串
 * 很类似找出两个字符串中所有的字母异味词，但是重点为：
 * T438中是以字符进行hash求diff，这里根据单词hash求diff
 * 求diff是关键点，如何求得两个字符串所蕴含的单词的diff
 * @Datetime: 2024/3/14 14:21
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/">串联所有单词的字串</a>
 */
public class T30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();
        int allWordLen = wordLen * words.length;
        if (s.length() < allWordLen) {
            return res;
        }
        Map<String, Integer> mapWord = new HashMap<>();
        for (String string : words) {
            mapWord.put(string, mapWord.getOrDefault(string, 0) + 1);
        }
        for (int k = 0; k < wordLen; k++) {
            if (k + allWordLen > s.length()) {
                break;
            }
            Map<String, Integer> mapS = new HashMap<>();
            int diff = 0;
            int index = k;
            for (int i = 0; i < words.length; i++, index += wordLen) {
                String word = s.substring(index, index + wordLen);
                mapS.put(word, mapS.getOrDefault(word, 0) + 1);
            }
            // S出现的words未出现的和words出现的，但是S未出现的，diff应该增加为各自单词出现的数量，
            // 且这里的处理需要和移动窗口时保持一致(即新加入的单词和移除的单词，如果二者其中一个没有，那么就需要进行对应的diff++ or diff--)
            for (String word : mapWord.keySet()) {
                if (!mapS.containsKey(word)) {
                    diff += mapWord.get(word);
                } else if (!mapS.get(word).equals(mapWord.get(word))) {
                    // 应该计算二者持有数量的差的绝对值
                     diff += Math.abs(mapS.get(word) - mapWord.get(word));
                }
            }
            for (String word : mapS.keySet()) {
                if (!mapWord.containsKey(word)) {
                    diff += mapS.get(word);
                }
            }
            if (diff == 0) {
                res.add(k);
            }
            for (int i = wordLen + k; i < s.length(); i += wordLen) {
                if (i + allWordLen > s.length()) {
                    break;
                }
                String wordNew = s.substring(i + allWordLen - wordLen, i + allWordLen);
                String wordOld = s.substring(i - wordLen, i);
                if (!mapWord.containsKey(wordOld)) {
                    diff--;
                } else if (mapS.get(wordOld) > mapWord.get(wordOld)) {
                    // 持有被wordOld的数量之差在缩小
                    diff--;
                } else  {
                    // 持有被wordOld的数量之差在增大
                    diff++;
                }
                mapS.put(wordOld, mapS.getOrDefault(wordOld, 0) - 1);
                if (!mapWord.containsKey(wordNew)) {
                    diff++;
                } else if (mapS.getOrDefault(wordNew, 0) >= mapWord.get(wordNew)) {
                    // 持有被wordNew的数量之差在增大
                    diff++;
                } else  {
                    // 持有被wordNew的数量之差在减小
                    diff--;
                }
                mapS.put(wordNew, mapS.getOrDefault(wordNew, 0 ) + 1);
                if (diff == 0) {
                    res.add(i);
                }
            }
        }
        return res;
    }

    /**
     * 上述方法的优化版，不再需要diff，而是采用diff map
     * @return
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T30().findSubstring("bcabbcaabbccacacbabccacaababcbb", new String[]{"c","b","a","c","a","a","a","b","c"}));
        System.out.println(new T30().findSubstring1("bcabbcaabbccacacbabccacaababcbb", new String[]{"c","b","a","c","a","a","a","b","c"}));
    }
}
