package math;

public class Powxn {

  public static void main(String[] args) {
    System.out.println(myPow(2.00000, 13));
  }

  /**
   * офигеть какой просто подход, в тупую он решается конечно же обычным циклом но это не оптимально
   * а что если нам посчитать степень только для половоины степени??
   *
   * ну на пример нас просят 2^8 что насчет 2 возвести в квадрат = 4 и потом умножить снова этот квадрат?
   *
   * круто! работает!
   *
   * так и будем делать только проблема в том что может быть что число не делится на 2 и что делать??
   *
   * а ничего стращного можно сделать деление по модуюлю получит
   * отстаток от делния и возвести наше число в остаток от деления
   */

  static double myPow(double x, int n) {
    if (n == 1) {
      return x;
    }

    if (n == -1) {
      return 1 / x;
    }

    if (n == 0) {
      return 1.0;
    }

    double half = myPow(x, n / 2);
    return half * half * myPow(x, n % 2);
  }

}
