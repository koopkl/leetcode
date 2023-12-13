package org.example.array;

/**
 * 比较含退格的字符串
 * @link <a href=""> </a>
 */
public class T844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder strB = new StringBuilder();
        return deleteBlank(s).equals(deleteBlank(t));
    }

    public String deleteBlank(String s) {
        StringBuilder strB = new StringBuilder();
        int skip = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                skip++;
            } else {
                if (skip > 0) {
                    skip--;
                } else {
                    strB.append(s.charAt(i));
                }
            }
        }
        System.out.println(strB);
        return strB.toString();
    }

    public boolean constantBackspaceCompare(String s, String t) {
        int skips = 0, skipt = 0;
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skips++;
                } else {
                    if (skips > 0) {
                        skips--;
                    } else {
                        break;
                    }
                }
                i--;
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipt++;
                } else {
                    if (skipt > 0) {
                        skipt--;
                    } else {
                        break;
                    }
                }
                j--;
            }
            if (i < 0 && j < 0) {
                return true;
            } else if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }
}
