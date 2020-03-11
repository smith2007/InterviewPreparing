package slidind_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) {
            return 0;
        }

        int i = 0;
        int j = 0;

        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        int max = 0;
        while (j < chars.length) {

            char jch = chars[j];
            map.merge(jch, 1, Integer::sum);

            if (map.size() <= 2) {
                max = Math.max(j - i + 1, max);
            } else {
                while (map.size() > 2) {
                    char ich = chars[i];
                    Integer counti = map.get(ich);
                    if (counti - 1 == 0) {
                        map.remove(ich);
                    } else {
                        map.put(ich, counti - 1);
                    }
                    i++;
                }
            }

            j++;
        }

        return max;
    }
}
