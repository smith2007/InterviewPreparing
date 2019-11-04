package fibonacci;

public class ClimbingStairsWithDP {

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }
    //сложность O(mn) - всего m ступенек где n - энная ступенька которую надо покорить
    static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1; // начинаем блять с индекса 1 потому что индекс это кол-во ступенек
        //для одной ступеньки у нас только один вариант - один шаг

        dp[2] = 2; // для двух ступенек это два варианта
        //ну и все матрица епта

        //раскручиваем массив - заполняем массив
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
