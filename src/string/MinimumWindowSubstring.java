package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "a";
        String t = "a";

        String minWindow = minWindow(s, t);

        System.out.println(minWindow);
    }


    static String minWindow(String s, String t) {

        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }


        if (s.length() < t.length()) {
            return "";
        }


        // грубо говоря мапа в ней чар - напротив в ней кол-во символов

        Map<Character, Integer> tmap = new HashMap<>();


        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }


        int start = 0;
        int end = 0;
        int strLen = s.length();

        int i = 0;
        int j = 0;

        boolean flag = false;

        while (j < s.length()) {

            int currLen = (j - i) + 1;

            Integer count = tmap.get(s.charAt(j));
            if (count != null) {
                tmap.put(s.charAt(j), count - 1);
            }


            if (currLen >= t.length()) {
                while (isAllZeroOrLess(tmap)) {
                    currLen = (j - i) + 1;
                    if (currLen <= strLen) {
                        start = i;
                        end = j;
                        strLen = end - start + 1;
                        flag = true;
                    }

                    Integer counti = tmap.get(s.charAt(i));
                    if (counti != null) {
                        tmap.put(s.charAt(i), counti + 1);
                    }
                    i++;
                }
            }
            j++;
        }

        if (start == 0 && end == 0 && strLen == s.length() && !flag) {
            return "";
        }

        return s.substring(start, end + 1);
    }

    static boolean isAllZeroOrLess(Map<Character, Integer> map) {
        for (Integer c : map.values()) {
            if (c > 0) {
                return false;
            }
        }
        return true;
    }
}
