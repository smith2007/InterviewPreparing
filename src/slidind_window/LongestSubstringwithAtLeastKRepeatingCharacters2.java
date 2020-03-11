package slidind_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtLeastKRepeatingCharacters2 {

  public static void main(String[] args) {
    System.out.println(longestSubstring("aabbba", 3));
  }


  static int longestSubstring(String str, int k) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();

    char[] chars = str.toCharArray();
    for (char c : chars) {
      map.merge(c, 1, Integer::sum);
    }

    boolean flag = true;
    for (Integer value : map.values()) {
      if (value < k) {
        flag = false;
        break;
      }
    }

    if (flag) {
      return str.length();
    }

    int i = 0;
    int j = 0;

    int max = 0;

    //aaabb
    while (j < chars.length) {

      char charj = chars[j];
      if (map.get(charj) < k) {
        max = Math.max(max, longestSubstring(str.substring(i, j), k));
        i = j + 1;
      }

      j++;
    }

    return Math.max(max, longestSubstring(str.substring(i), k));
  }


}
