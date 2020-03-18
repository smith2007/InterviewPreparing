package math;

import java.util.HashMap;
import java.util.Map;

public class IntegertoEnglishWords {

  public static void main(String[] args) {
    IntegertoEnglishWords integertoEnglishWords = new IntegertoEnglishWords();
    System.out.println(integertoEnglishWords.numberToWords(123));
  }

  // итак перед нами три массива первый единицы - меньше 10 условно
  private final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six",
      "Seven", "Eight", "Nine"};

  // второй 12 13 14 и тд все что меньше 20
  private final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen",
      "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  //третий с десятками
  private final String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty",
      "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  public String numberToWords(int num) {
    if (num == 0) {
      //сразу проверяем на ноль
      return "Zero";
    }
    return helper(num);
  }

  public String helper(int num) {
    String result = "";
    //хотим знать длинну нашего числа
    int length = (num + "").length();
    //так же сразу проверяем стоит ли вообще возится с этим числом
    //может оно меньше 10
    if (num < 10) {
      return belowTen[num];
    } else if (length < 3) {
      //мы понимае что если длинна нашего числа < 3 символов то тут уже надо специфические кейсы
      //рассматривать такие как 40 60 19 и тд
      int d1 = num / 10;
      int d2 = num % 10;

      if (d2 == 1) {
        return belowTwenty[d2];
      } else {
        result = belowTen[d1] + " " + belowHundred[d2];
      }

    } else if (length == 3) {

      //а вот если нет, если длинна нашего числа более 3 симолов то тут надо
      //иметь дело с hundred thousand и тд
      //остается понять какая длинна нашего числа если 3 символа - то это сотни
      //700 432 324 и тд
      // соответсвенно мы понимаем что перед нами сотни по этому сто пудово вставляем слово Hundred
      //далее надо понять сколько сотен и присабачить слева и сколько десятых и присабачить справа
      //для того что бы это сделать вызываем рекурсивно для первого разряда
      //helper(num % 10) и для последних разрядов helper(num / 10) и схлопываем
      result = helper(num / 100) + " Hundred " + helper(num % 100);
    } else if (length == 4) {
      //если 4 символа то это от 1 до 9 тысяч как правило то есть 7621 4898 и тд
      result = belowTen[num % 10] + " Thousand " + helper(num / 10);
    } else if (length == 5) {
      //если 5 символов то это от 10 до 99 тысяч
      result = helper(num % 100) + " Thousand " + helper(num / 100);
    } else if (length == 6) {
      //если 6 символов то перед нами число из от 100 000 до 999 999
      result = helper(num % 1000) + " Thousand " + helper(num / 1000);
    } else if (length == 7) {
      //ну и далее пошли миллионы
      result = belowTen[num % 10] + " Million " + helper(num / 10);
    } else if (length == 8) {
      result = helper(num % 100) + " Million " + helper(num / 100);
    } else if (length == 9) {
      result = helper(num % 1000) + " Million " + helper(num / 1000);
    } else if (length == 10) {
      result = belowTen[num % 10] + " Billion " + helper(num / 10);
    } else if (length == 11) {
      result = helper(num % 100) + " Billion " + helper(num / 100);
    } else if (length == 12) {
      result = helper(num % 1000) + " Billion " + helper(num / 1000);
    }
    return result.trim();
  }

}
