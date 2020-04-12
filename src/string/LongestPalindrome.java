package string;

import java.util.HashMap;

public class LongestPalindrome {


  /**
   * задача решается через мапу, наша задача набивать каунтер как только мы встрелили какой - то
   * символ дважды
   */
  public int longestPalindrome(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();

    for (char c : s.toCharArray()) {
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }

    int res = 0;
    boolean oddFound = false;
    for (Integer count : hm.values()) {
      if (count % 2 == 1) {
        oddFound = true;
        res += (count - 1);
      } else {
        res += count;
      }

    }
    return oddFound ? (res + 1) : res;
  }

}
