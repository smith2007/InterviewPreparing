package graph;

import java.util.HashMap;
import java.util.Map;

public class KSimilarStrings {

  /**
   * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of
   * two letters in A exactly K times so that the resulting string equals B.
   * <p>
   * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
   * <p>
   * Example 1:
   * <p>
   * Input: A = "ab", B = "ba" Output: 1 Example 2:
   * <p>
   * Input: A = "abc", B = "bca" Output: 2 Example 3:
   * <p>
   * Input: A = "abac", B = "baca" Output: 2 Example 4:
   * <p>
   * Input: A = "aabc", B = "abca" Output: 2
   *
   * https://leetcode.com/problems/k-similar-strings/discuss/139872/Java-Backtracking-with-Memorization
   */
  public int kSimilarity(String A, String B) {
    Map<String, Integer> map = new HashMap<>();
    return dfs(A.toCharArray(), B.toCharArray(), 0, map);
  }

  private int dfs(char[] A, char[] B, int start, Map<String, Integer> memo) {
    boolean same = true;
    for (int i = start; i < B.length; i++) {
      if (A[i] != B[i]) {
        same = false;
        start = i;
        break;
      }
    }
    if (same) {
      return 0;
    }

    // unmatch
    String unmatch = String.valueOf(A, start, B.length - start);
    if (memo.containsKey(unmatch)) {
      return memo.get(unmatch);
    }
    int min = Integer.MAX_VALUE;
    for (int j = start + 1; j < B.length; j++) {
      // find all candidates position where A[j] == B[start]
      // aabda
      // adb
      if (A[j] == B[start] && A[j] != B[j]) {
        // swap  A[j] and A[start]
        swap(A, start, j);
        int next = dfs(A, B, start + 1, memo);
        min = Math.min(next + 1, min);
        // change it back
        swap(A, start, j);
        // reversed pair
        //   https://leetcode.com/problems/k-similar-strings/discuss/140871/java-+-backtracking-+-10ms
        if (min == 1 || A[start] == B[j]) {
          break;
        }
      }
    }
    memo.put(unmatch, min);
    return min;
  }

  private void swap(char[] cs, int i, int j) {
    char temp = cs[i];
    cs[i] = cs[j];
    cs[j] = temp;
  }
}
