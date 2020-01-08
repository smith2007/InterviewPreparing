package dynamic_programming;

import java.util.Arrays;

public class PerfectSquares {


    /**
     * 150.PerfectSquares
     * https://leetcode.com/problems/perfect-squares/
     * <p>
     * Дано положительное число n, необходимо найти минимальное кол-во идеальных по площади квадратов которые
     * вместятся в переданное на вход число
     * идеальный по площади квадрат имеет площади 1, 4, 9, 16, ...
     * <p>
     * <p>
     * Example 1:
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     * <p>
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     */
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    static int numSquares(int n) {
        //решаем через динамическое программирование
        int[] dp = new int[n + 1];

        //заполняем массив максимальными значениями
        //потому что потом будем брать минимум
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int index = i - j * j;
                dp[i] = Math.min(dp[i], dp[index] + 1);
            }
        }
        return dp[n];
    }
}
