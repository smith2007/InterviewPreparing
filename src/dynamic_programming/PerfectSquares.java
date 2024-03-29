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
        //идея такая - два указателя i и j
        //i убегает вперед j каждый раз его догоняет
        //идея такая - а вот рассматривая что максимальный элемент у нас i
        //сколько прямоугольников тут поместится???
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (true) {
                //вот тут мы как бы проверяем не переходит ли наш элемент границу
                //то есть не превышает ли он текущий максимальный элемент нашей динамической итерации
                //а какой будет максимальный элемент?
                // i будет - вот она где зарыта собака динамического программирования то
                int jSqrt = j * j;
                if (jSqrt > i) {
                    break;
                }
                int index = i - jSqrt;
                //новый элемент мы рассматриваем как предыдущее как бы значение
                //плюс 1, а почему плюс 1 спросите вы
                //да потому что единица это минимальная площадь треугольника который вписывается
                int newElm = dp[index] + 1;
                dp[i] = Math.min(dp[i], newElm);

                j++;
            }
        }
        return dp[n];
    }
}
