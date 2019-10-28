package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            char charj = s.charAt(j);
            int newCount = map.getOrDefault(charj, 0) + 1;
            map.put(charj, newCount);

            if (newCount > 1) {
                while (map.get(charj) != 1) {
                    char chari = s.charAt(i);

                    map.put(chari, map.get(chari) - 1);
                    i++;
                    if (i == j) {
                        break;
                    }
                }
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }


        return maxLength;
    }
}
