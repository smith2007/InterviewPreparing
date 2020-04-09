package math;

public class DivideTwoIntegersSlow {

  public static void main(String[] args) {
    DivideTwoIntegersSlow ins = new DivideTwoIntegersSlow();
    System.out.println(ins.divide(256, 8));
  }

  /**
   * First, we check for the special case dividend == Integer.MIN_VALUE && divisor == -1 We get the
   * absolute value of dividend and divisor Do the division for 2 positive numbers using "Adding
   * Powers Of Two" technique
   */

  public int divide(int dividend, int divisor) {

    //проверяем, если делимое равняется макс число
    //а делитель == -1 то ответ по любому будет MAX_VALUE
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    //дальше берем по модулю
    int dividendAbs = Math.abs(dividend);
    int divisorAbs = Math.abs(divisor);

    int res = dividePositive(dividendAbs, divisorAbs);
    //если оба положительный или оба отрицательные - возвращаем с плюсом результат
    if (dividend > 0 && divisor > 0) {
      return res;
    } else if (dividend < 0 && divisor < 0) {
      return res;
    } else {
      //если хоть кто-то был с минусом - возвращаем с минусом
      return -res;
    }
  }

  /**
   * тут суть такая - мы пытаемся приближаться к нашему числу итеративно идя от нашего делителя и
   * постепенно умножая его на два
   * <p>
   * паралельно считаем шаги - сколько раз мы сделали такие вот приближения если при очередном
   * приближении мы перешли наше число - давай уменьшим наш кумулятивный делитель
   */
  private int dividePositive(int dividend, int divisor) {
    int totalSteps = 0;
    while (dividend - divisor >= 0) {
      int step = 1;
      int cumulativeDivisor = divisor;
      //например 256 и 8
      // идем по шага первый проход 8 16 32 64 128 - хоп 256 == 0 как бы см кондишен
      //уменьшаем делимое на значение этого кумулятивного и опять идем и делаем
      while (dividend - (cumulativeDivisor + cumulativeDivisor) > 0) {
        cumulativeDivisor += cumulativeDivisor;
        step += step;
      }

      totalSteps += step;
      dividend = dividend - cumulativeDivisor; // Decrement Dividend
    }

    return totalSteps;
  }
}
