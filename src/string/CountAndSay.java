package string;

public class CountAndSay {

  /**
   * идея в том что нам надо всегда знать предыдущее значение
   * что бы сгенерировать новое
   */
  public String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    // тут получаем предыдущее значение
    String prev = countAndSay(n - 1);

    StringBuilder res = new StringBuilder();
    //дальше двумя указателями
    int i = 0;
    while (i < prev.length()) {
      //получаем текущий символ
      char currSymbol = prev.charAt(i);
      int countOfCurrSymbol = 0;
      //бежим до тех пор пока у нас этот символ и набиваем каунтер
      while (i + countOfCurrSymbol < prev.length() && prev.charAt(i + countOfCurrSymbol) == currSymbol) {
        countOfCurrSymbol++;
      }
      res.append(countOfCurrSymbol);
      res.append(currSymbol);
      //смещаем наш указатель на то кол-во символов сколько у нас продолжался наш текущий символ
      i += countOfCurrSymbol;
    }
    return res.toString();
  }


}
