package slidind_window;

import java.util.HashMap;
import java.util.TreeSet;

public class MinimumWindowSubsequence {

  /**
   * суть в том что объединяем окно и три сет для того чтобы определить
   * subsequence(T) который может бы сформирован текущим окном
   *
   * This solution uses a combination of Sliding window technique and a TreeSet to identify if the
   * subsequence(T) can we formed in current window.
   *
   *
   * The run time of this method is O(S * T log S).
   * This can be further optimized to O(S * T log T) by storing only the characters of T in the
   * TreeSet.
   */
  public String minWindow(String str, String target) {
    HashMap<Character, TreeSet<Integer>> cache = new HashMap<>();
    int len = Integer.MAX_VALUE;

    int start = -1;
    int end = -1;

    int sIndex = 0;
    int tIndex = 0;

    while (start <= str.length() - target.length()) {
      if (tIndex >= target.length()) {
        start++;
        if (end - start + 1 < len) {
          len = end - start + 1;
          sIndex = start;
        }
        cache.get(str.charAt(start)).remove(start);
        tIndex = validate(cache, target);
        continue;
      }
      if (end >= str.length() - 1) {
        break;
      }
      end++;
      if (cache.containsKey(str.charAt(end))) {
        cache.get(str.charAt(end)).add(end);
      } else {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(end);
        cache.put(str.charAt(end), set);
      }
      tIndex = validate(cache, target);
    }
    return len != Integer.MAX_VALUE ? str.substring(sIndex, sIndex + len) : "";
  }

  int validate(HashMap<Character, TreeSet<Integer>> cache, String T) {
    int prev = -1;
    int i = 0;
    for (; i < T.length(); i++) {
      char c = T.charAt(i);
      if (!cache.containsKey(c) || cache.get(c).higher(prev) == null) {
        break;
      }
      prev = cache.get(c).higher(prev);
    }
    return i;
  }
}
