package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters2 {

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }

    static int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int i = 0;
        int j = 0;


        while (j < str.length()) {

            int newCount = map.getOrDefault(str.charAt(j), 0) + 1;

            map.put(str.charAt(j), newCount);

            if (newCount > 1) {
                while (map.get(str.charAt(j)) != 1) {
                    Integer counti = map.get(str.charAt(i));
                    if (counti - 1 == 0) {
                        map.remove(str.charAt(i));
                    } else {
                        map.put(str.charAt(i), counti - 1);
                    }

                    i++;
                    if (i == j) {
                        break;
                    }
                }
            }
            max = Math.max(max, j - i + 1);

            j++;


        }


        return max;
    }
}
