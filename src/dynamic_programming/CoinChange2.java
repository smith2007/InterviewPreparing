package dynamic_programming;

public class CoinChange2 {

  /**
   *
   *
   *
   * Вам дают монеты разных номиналов и общую сумму денег. Напишите функцию
   * для вычисления количества комбинаций, составляющих эту сумму.
   * Вы можете предположить, что у вас есть бесконечное количество монет каждого вида.
   *
   * классическая задача на рюкзак
   *
   *
   * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
   *
   *
   *
   * Example 1:
   *
   * Input: amount = 5, coins = [1, 2, 5]
   * Output: 4
   * Explanation: there are four ways to make up the amount:
   * 5=5
   * 5=2+2+1
   * 5=2+1+1+1
   * 5=1+1+1+1+1
   * Example 2:
   *
   * Input: amount = 3, coins = [2]
   * Output: 0
   * Explanation: the amount of 3 cannot be made up just with coins of 2.
   * Example 3:
   *
   * Input: amount = 10, coins = [10]
   * Output: 1
   */

  /**
   * This is a classic knapsack problem. Honestly, I'm not good at knapsack problem, it's really tough for me.
   *
   * dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
   * State transition:
   *
   * not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
   * using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount j - coins[i-1] by using first i coins(including ith), which is dp[i][j-coins[i-1]]
   * Initialization: dp[i][0] = 1
   *
   * public int change(int amount, int[] coins) {
   *         int[][] dp = new int[coins.length+1][amount+1];
   *         dp[0][0] = 1;
   *
   *         for (int i = 1; i <= coins.length; i++) {
   *             dp[i][0] = 1;
   *             for (int j = 1; j <= amount; j++) {
   *                 dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
   *             }
   *         }
   *         return dp[coins.length][amount];
   *     }
   *
   *     Now we can see that dp[i][j] only rely on dp[i-1][j] and dp[i][j-coins[i]], then we can optimize the space by only using one-dimension array.
   */


  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i-coin];
      }
    }
    return dp[amount];
  }
}
