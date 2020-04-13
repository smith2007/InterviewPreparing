package dynamic_programming;

public class MinimumCostToMergeStones {

  /**
   * There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.
   * <p>
   * A move consists of merging exactly K consecutive piles into one pile, and the cost of this move
   * is equal to the total number of stones in these K piles.
   * <p>
   * Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return
   * -1.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: stones = [3,2,4,1], K = 2 Output: 20 Explanation: We start with [3, 2, 4, 1]. We merge
   * [3, 2] for a cost of 5, and we are left with [5, 4, 1]. We merge [4, 1] for a cost of 5, and we
   * are left with [5, 5]. We merge [5, 5] for a cost of 10, and we are left with [10]. The total
   * cost was 20, and this is the minimum possible. Example 2:
   * <p>
   * Input: stones = [3,2,4,1], K = 3 Output: -1 Explanation: After any merge operation, there are 2
   * piles left, and we can't merge anymore.  So the task is impossible. Example 3:
   * <p>
   * Input: stones = [3,5,1,2,6], K = 3 Output: 25 Explanation: We start with [3, 5, 1, 2, 6]. We
   * merge [5, 1, 2] for a cost of 8, and we are left with [3, 8, 6]. We merge [3, 8, 6] for a cost
   * of 17, and we are left with [17]. The total cost was 25, and this is the minimum possible.
   * <p>
   * <p>
   * Note:
   */

  /**
   * Explanation
   * Suggested by @yaoct, we can simplify the third parameter m in DP.
   *
   * stones[i] ~ stones[j] will merge as much as possible.
   *
   * Finally (j - i) % (K - 1) + 1 piles will be left.
   *
   * It's less than K piles and no more merger happens.
   *
   * dp[i][j] means the minimum cost needed to merge stones[i] ~ stones[j].
   *
   * Complexity
   * Time O(N^3/K) Space O(N^2)
   * It can be improved, but I think it's fine now.
   *
   * https://leetcode.com/problems/minimum-cost-to-merge-stones/discuss/247567/JavaC%2B%2BPython-DP
   */

  public int mergeStones(int[] stones, int K) {
    int n = stones.length;
    if ((n - 1) % (K - 1) > 0) {
      return -1;
    }

    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + stones[i];
    }

    int[][] dp = new int[n][n];
    for (int m = K; m <= n; ++m) {
      for (int i = 0; i + m <= n; ++i) {
        int j = i + m - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int mid = i; mid < j; mid += K - 1) {
          dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
        }
        if ((j - i) % (K - 1) == 0) {
          dp[i][j] += prefix[j + 1] - prefix[i];
        }
      }
    }
    return dp[0][n - 1];
  }

}
