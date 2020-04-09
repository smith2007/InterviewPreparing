package math;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

  /**
   * два указателя, слева и справа ё
   * смотрим что символы валидные слева и справа
   *
   * дальше сжимаем окно
   */
  public boolean isStrobogrammatic(String num) {
    Map<Character, Character> map = new HashMap<>();
    map.put('6', '9');
    map.put('9', '6');
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');

    int left = 0;
    int right = num.length() - 1;
    while (left <= right) {
      char leftSymbol = num.charAt(left);
      Character oppositeLeftSymbol = map.get(leftSymbol);
      if (oppositeLeftSymbol == null || oppositeLeftSymbol != num.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

}
