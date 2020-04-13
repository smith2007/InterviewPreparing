package dynamic_programming;

public class WildcardMatching {

  /**
   * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
   *
   * '?' Matches any single character.
   * '*' Matches any sequence of characters (including the empty sequence).
   * The matching should cover the entire input string (not partial).
   *
   * Note:
   *
   * s could be empty and contains only lowercase letters a-z.
   * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
   * Example 1:
   *
   * Input:
   * s = "aa"
   * p = "a"
   * Output: false
   * Explanation: "a" does not match the entire string "aa".
   * Example 2:
   *
   * Input:
   * s = "aa"
   * p = "*"
   * Output: true
   * Explanation: '*' matches any sequence.
   */


  boolean comparison(String str, String pattern) {
    int s = 0;
    int p = 0;
    int match = 0;
    int starIdx = -1;

    while (s < str.length()){
      // advancing both pointers
      if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
        s++;
        p++;
      }
      // * found, only advancing pattern pointer
      else if (p < pattern.length() && pattern.charAt(p) == '*'){
        starIdx = p;
        match = s;
        p++;
      }
      // last pattern pointer was *, advancing string pointer
      else if (starIdx != -1){
        p = starIdx + 1;
        match++;
        s = match;
      }
      //current pattern pointer is not star, last patter pointer was not *
      //characters do not match
      else return false;
    }

    //check for remaining characters in pattern
    while (p < pattern.length() && pattern.charAt(p) == '*')
      p++;

    return p == pattern.length();
  }

}
