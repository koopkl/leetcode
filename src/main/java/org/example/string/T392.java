package org.example.string;

public class T392 {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i)) {
                index++;
            }
        }
        return index == s.length();
    }
}
