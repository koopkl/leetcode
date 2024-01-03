package org.example.hashtable;

import java.util.*;

public class T49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] book = new int[strs.length];
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (book[i] == 1) {
                continue;
            }
            String s = strs[i];
            List<String> tempList = new ArrayList<>();
            tempList.add(s);
            for (int j = i + 1; j < strs.length; j++) {
                if (book[j] == 1) {
                    continue;
                }
                String s1 = strs[j];
                boolean flag = compareMap(s, s1);
                if (flag) {
                    tempList.add(s1);
                    book[j] = 1;
                }
            }
            res.add(tempList);
        }
        return res;
    }


    public boolean compareMap(String s1, String s2) {
       int[] book = new int[26];
       if (s1.length() != s2.length()) {
           return false;
       }
       for (int i = 0; i < s1.length(); i++) {
           book[s1.charAt(i) - 'a'] ++;
           book[s2.charAt(i) - 'a'] --;
       }
       for (int i = 0; i < book.length; i++) {
           if (book[i] < 0) {
               return false;
           }
       }
       return true;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String temp = new String(charArray);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        return map.values().stream().toList();
    }
}
