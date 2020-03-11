package slidind_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringKDistinct("bacc", 2));

    }

    static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (s == null || k == 0) {
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

            if (map.size() <= k) {
                max = Math.max(j - i + 1, max);
            } else {
                while (map.size() > k) {
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
