package divide_and_conquer;

public class BurstBalloons {

  public static void main(String[] args) {

  }

  /**
   * идея как бы в том что бы потихоньку отщипывать от краев элементы и считать такую вот подсумму
   * выбирая срединный элемент через деление пополам
   * <p>
   * и дальше мы этот срединный не отщипываем, мы его оставляем в массиве
   * <p>
   *
   * прежде всего dp[i][j] здесь означает МАКСИМУМ очков которые мы можем получит после взрыва ВСЕХ
   * шариков между индексами start и end в нашем массиве
   *
   * например наш массив [3,1,5,8] :
   *
   *
   * dp[0][0] означает мы взрываем шарики между 0,0 - это значит мы взрываем только
   * шарик с индексом i = 0 получается что dp[0][0] is 1 * 3 * 1 = 3.
   *
   * dp[1][1] означает что мы взрываем шарики между [1][1],
   * что означает что мы взрываем только шарик с индексом i = 1
   * получается что dp[1][1] is 3 * 1 * 5 = 15.
   *
   * таким образом в конце этого алгоритма мы хотим найти dp[0][ arr.length - 1 ]
   * что означает - максимальное значение которое мы можем получит взрывая все
   * шарики между [0 , length -1]
   *
   * то есть СУТЬ - мы будем искать МАКС КОЛ-ВО ОЧКОВ НА ПОДМАССИВАХ
   *
   **/
  int[][] dp;

  public int maxCoins(int[] nums) {
    dp = new int[nums.length][nums.length];
    return maxCoins(nums, 0, nums.length - 1);
  }


  public int maxCoins(int[] nums, int start, int end) {
    if (start > end) {
      return 0;
    }
    if (dp[start][end] != 0) {
      return dp[start][end];
    }
    int maxCoins = nums[start];
    //НАМ НАДО ВЗОРВАТЬ ВСЕ МАССИВЫ НА НАШЕМ ПОДМАМАССИВЫ
    //мы работаем по принципу разделяй и влавствуй
    //нам надо взорвать ВСЕ и выбрать максимум
    //сводим задачу к подзадаче - а именно докатываемся до
    //простого кейса когда у нас массив из одного элемента
    for (int i = start; i <= end; i++) {

      int currCoins = get(nums, start - 1) * get(nums, i) * get(nums, end + 1);

      int maxCoinsFromLeft = maxCoins(nums, start, i - 1);
      int maxCoinsFromRight = maxCoins(nums, i + 1, end);
      int totalCoins = maxCoinsFromLeft + currCoins + maxCoinsFromRight;
      //мы набиваем максимум из того что есть
      maxCoins = Math.max(maxCoins, totalCoins);
    }
    dp[start][end] = maxCoins;
    return maxCoins;
  }

  public int get(int[] nums, int i) {
    if (i == -1 || i == nums.length) {
      return 1;
    }
    return nums[i];
  }
}
