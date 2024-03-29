package dynamic_programming;

import java.util.Arrays;

public class CoinChange {

  /**
   * Даны наборы монет номиналом 1,2,5 - а так же сумма денег 11 - посчитай минимально необходимы
   * набор монет разного номинала что бы получить эту сумму, монет мы можем использовать сколько
   * угодно в данном случае ответ 3 : 5+5+1 = 11 если достичь этой суммы с помощью этих монет нельзя
   * - возвращаем -1
   * <p>
   * тут классика динамического программирования,  у нас есть сумма - 11 и бесконечно кол-во монет
   * номиналом 1-2-5
   * <p>
   * идея - считаем задачу для подзадачи, потом на основании посчитанного высчитываем следующую
   * итерацию конкретно тут:
   * <p>
   * строим массив dp - размером с нашу требуемую сумму - 11, каждый индекс - сумма
   * 1-2-3-4-5-6-7-8-9-10-11 далее раскручиваем два цикла первый по монетам - то есть сначала
   * рассматриваем базовый случай с одной монетой
   * <p>
   * второй цикл по суммам - то есть будем рассматривать базовый случай с одной монетой и одним
   * рублем, затем 2 рубля 3 рубля и так далее
   * <p>
   * но ведь есть ситуации когда мы не можем однозначно посчитать, например у нас монеты 5 руб а
   * сумма 8, в таком случае в массиве с индексом 8 (тобиш для суммы 8 руб) мы оставляем маркер не
   * можем посчитать - например Int .MAX_VALUE и предварительно заполним это наш массив -
   * проинициализируем
   * <p>
   * как вычислить итый элемент массива : dp[i] = Math.min(onPrevStepAndCoins, consideringNewCoin);
   * int onPrevStepAndCoins = dp[i]; int consideringNewCoin = dp[i - coin] + 1; - для оставшейся
   * суммы
   */
  static int change(int[] coins, int amount) {

    if (coins.length == 0) {
      return -1;
    }
    //
    //еще раз - в массиве dp - будет лежать
    // МИНИМАЛЬНОЕ КОЛ-ВО МОНЕТ НУЖНОЕ ДЛЯ ФОРМИРОВАНИЯ ЭТОЙ СУММЫ, не номинал,
    // ни общая сумма а именно минимальное кол-во монет
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int coin : coins) {
      //начинаем с суммы равной номиналу монеты
      for (int i = coin; i <= amount; i++) {
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
          //внимание
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
