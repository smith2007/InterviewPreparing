package dynamic;

import java.util.Arrays;

public class CoinChange {
    static int change(int[] coins, int amount) {

        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {//начинаем с суммы равной номиналу монеты
                //в этой строке смотрим посчитан ли резльтат для оставшейся суммы
                //еще раз итый индекс показывает нам эмаунт для которого мы считаем
                //монеты, если для оставшейся суммы, монеты не посчитаны, то дальше нет смысла
                //сравнивать
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    //классика динамического программирования
                    //берем кол-во монет для этой суммы посчитанной на прошлом шаге
                    int onPrevStepAndCoins = dp[i];

                    //высчитываем кол-во монет нужное с учетом новой монеты
                    // вот эта плюс один и есть наша новая монета которую мы добавляем к кол-ву
                    // условно берем минимальное кол-во монет с предыдущего шага и прибавляем
                    // новую монету, нового номинала
                    int consideringNewCoin = dp[i - coin] + 1;

                    //смотрим что же будет меньше по кол-ву
                    dp[i] = Math.min(onPrevStepAndCoins, consideringNewCoin);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {5, 1, 2};

        System.out.println(change(coins, 11));
    }

}
