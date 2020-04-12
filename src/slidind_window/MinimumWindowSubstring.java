package slidind_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String minWindow = minWindow(s, t);

        System.out.println(minWindow);
    }

    /**
     * тут принцип окна
     *
     * sliding window + 2 pointers + method isAllZeroOrLess
     */
    static String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        if (s.length() < t.length()) {
            return "";
        }

        // грубо говоря мапа в ней чар - напротив в ней кол-во символов
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int end = 0;
        int strLen = s.length();

        int i = 0;
        int j = 0;
        boolean flag = false;

        while (j < s.length()) {
            int currLen = (j - i) + 1;
            Integer count = charCountMap.get(s.charAt(j));
            if (count != null) {
                charCountMap.put(s.charAt(j), count - 1);
            }

            if (currLen >= t.length()) {
                while (isAllZeroOrLess(charCountMap)) {
                    currLen = (j - i) + 1;
                    if (currLen <= strLen) {
                        start = i;
                        end = j;
                        strLen = end - start + 1;
                        flag = true;
                    }

                    Integer counti = charCountMap.get(s.charAt(i));
                    if (counti != null) {
                        charCountMap.put(s.charAt(i), counti + 1);
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
