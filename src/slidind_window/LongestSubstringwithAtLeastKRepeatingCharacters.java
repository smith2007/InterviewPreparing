package slidind_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabbb", 3));
    }


    static int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> flags = new HashSet<>();

        char[] chars = s.toCharArray();

        int i = 0;
        int j = 0;

        int max = 0;
        while (j < chars.length) {
            map.merge(chars[j], 1, Integer::sum);

            if (map.get(chars[j]) == k) {
                flags.add(chars[j]);
            }

            if (flags.size() == map.size()) {
                max = Math.max(j - i + 1, max);
            } else if (flags.size() != 0 && map.size() > flags.size()) {
                while (map.size() > flags.size()) {
                    Integer counti = map.get(chars[i]);
                    if (counti - 1 < k) {
                        flags.remove(chars[i]);
                    }

                    if (counti - 1 == 0) {
                        map.remove(chars[i]);
                    } else {
                        map.put(chars[i], counti - 1);
                    }
                    i++;
                }
            }
            j++;
        }

        return max;

    }


}
