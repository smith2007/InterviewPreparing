package math;

import java.util.HashMap;
import java.util.Map;

public class IntegertoEnglishWordsMap {

  public static void main(String[] args) {
    IntegertoEnglishWordsMap integertoEnglishWords = new IntegertoEnglishWordsMap();
    System.out.println(integertoEnglishWords.numberToWords(123));
  }

  int BILLION = 1000000000;
  int MILLION = 1000000;
  int THOUSAND = 1000;
  int HUNDRED = 100;

  Map<Integer, String> hundredsMap;
  Map<Integer, String> teensMap;
  Map<Integer, String> oneMap;

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    hundredsMap = new HashMap<>();
    hundredsMap.put(9, "Ninety");
    hundredsMap.put(8, "Eighty");
    hundredsMap.put(7, "Seventy");
    hundredsMap.put(6, "Sixty");
    hundredsMap.put(5, "Fifty");
    hundredsMap.put(4, "Forty");
    hundredsMap.put(3, "Thirty");
    hundredsMap.put(2, "Twenty");

    teensMap = new HashMap<>();
    teensMap.put(19, "Nineteen");
    teensMap.put(18, "Eighteen");
    teensMap.put(17, "Seventeen");
    teensMap.put(16, "Sixteen");
    teensMap.put(15, "Fifteen");
    teensMap.put(14, "Fourteen");
    teensMap.put(13, "Thirteen");
    teensMap.put(12, "Twelve");
    teensMap.put(11, "Eleven");
    teensMap.put(10, "Ten");

    oneMap = new HashMap<>();
    oneMap.put(9, "Nine");
    oneMap.put(8, "Eight");
    oneMap.put(7, "Seven");
    oneMap.put(6, "Six");
    oneMap.put(5, "Five");
    oneMap.put(4, "Four");
    oneMap.put(3, "Three");
    oneMap.put(2, "Two");
    oneMap.put(1, "One");

    return convert(num).trim();
  }

  String convert(int num) {
    String res = "";
    // тут мы отталкиваемся от нашего числа, смотрим сколько оно
    //а оно больше чем миллиард?
    // ну и так по всему числу РЕКУРСИЕЙ
    if (num >= BILLION) {
      //если да больше надо откусить первые разряды и понять сколько миллиардов то 10 20 300 и тд
      //так же откусываем последние разряды и рекурсивно присабачиваем к слову миллиард
      res = convert(num / BILLION) + " Billion " + convert(num % BILLION);
    } else if (num >= MILLION) {
      res = convert(num / MILLION) + " Million " + convert(num % MILLION);
    } else if (num >= THOUSAND) {
      res = convert(num / THOUSAND) + " Thousand " + convert(num % THOUSAND);
    } else if (num >= HUNDRED) {
      res = convert(num / HUNDRED) + " Hundred " + convert(num % HUNDRED);
    } else if (num >= 20) {
      //стараемся свести к простым версиям типа 20 и меньше
      res = hundredsMap.get(num / 10) + " " + convert(num % 10);
    } else if (num >= 10) {
      //наше текущее число больше 10 но меньше 20?? да значит
      // мы между 19 и 10 потому что не зашли в предыдущий кондишн
      res = teensMap.get(num);
    } else if (num > 0) {
      //это число наконец больше 0 но меньше 10???
      //значит это единицы
      res = oneMap.get(num);
    }
    return res.trim(); // there will be extra spaces
  }


}
