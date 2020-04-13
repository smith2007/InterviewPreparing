package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  /**
   * Given two strings s and t, determine if they are isomorphic.
   *
   * Two strings are isomorphic if the characters in s can be replaced to get t.
   *
   * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
   *
   * Example 1:
   *
   * Input: s = "egg", t = "add"
   * Output: true
   * Example 2:
   *
   * Input: s = "foo", t = "bar"
   * Output: false
   * Example 3:
   *
   * Input: s = "paper", t = "title"
   * Output: true
   */

  /**
   * Two strings are isomorphic if the positions of the characters follow the same pattern. So I'm using maps to compare the position patterns.
   *
   * For example:
   *
   * String 1:              A B E A C D B
   * index pattern:         0 1 2 0 4 5 1
   * String 2:              X Y I X H K Y
   * index pattern:         0 1 2 0 4 5 1
   * Whether the two strings are isomorphic can be judged by the index patterns. In the above example, these two strings are isomorphic with the same index patterns.
   */

  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null) return false;
    if (s.length() != t.length()) return false;

    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapT = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      int indexS = mapS.getOrDefault(s.charAt(i), -1);
      int indexT = mapT.getOrDefault(t.charAt(i), -1);

      if (indexS != indexT) {
        return false;
      }

      mapS.put(s.charAt(i), i);
      mapT.put(t.charAt(i), i);
    }

    return true;
  }
}
