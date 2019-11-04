package fibonacci;

public class ClimbingStairsWithMemo {

    public static void main(String[] args) {

        System.out.println(climbStairs(5));
    }

    static int climbStairs(int n) {
        /**
         *  этот подходи уже с мемоизацией
         *  создаем массив длинной на один больше чем поданное на вход число
         */
        int[] memo = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    static int climb_Stairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }

        // проверяем в кэше есть что-то
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
