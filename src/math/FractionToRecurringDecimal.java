package math;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {


  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }
    StringBuilder result = new StringBuilder();
    // "+" or "-"
    if (numerator < 0 ^ denominator < 0) {
      result.append("-");
    }

    // Convert to Long or else abs(-2147483648) overflows
    long dividend = Math.abs(Long.valueOf(numerator));
    long divisor = Math.abs(Long.valueOf(denominator));

    //сразу добавляем целую часть
    result.append(dividend / divisor);

    //остаток от деления, если ноль, уходим
    long remainder = dividend % divisor;
    if (remainder == 0) {
      return result.toString();
    }
    result.append(".");
    //вот тут очень интересно, как сделать и корректно представить дробную часть
    //для того что бы это сделать надо класть в мапу
    //а затем если в мапе уже было это число - ставить скобки
    Map<Long, Integer> map = new HashMap<>();
    while (remainder != 0) {
      if (map.containsKey(remainder)) {
        result.insert(map.get(remainder), "(");
        result.append(")");
        break;
      }
      //кладем остаток в мапу
      map.put(remainder, result.length());
      //добавляем еще один разряд
      remainder *= 10;
      //и опять делим на делитель
      //и все это будем делать пока делитьель не будет равен 0 либо мы не будем зациклены по числам
      result.append(remainder / divisor);
      remainder %= divisor;
    }
    return result.toString();
  }

}
