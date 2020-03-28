package math;

import java.util.Stack;

public class BasicCalculatorIII {

  public static void main(String[] args) {
    BasicCalculatorIII calculatorIII = new BasicCalculatorIII();
    System.out.println(calculatorIII.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
  }

  /**
   * тут используется тот же принцип что и в BasicCalculatorII а именно стек
   */
  public int calculate(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }
    //на стек будем накладывать числа
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char prevSign = '+';

    for (int i = 0; i < s.length(); i++) {
      char currentCh = s.charAt(i);
      //если это число окей набиваем его разряды
      if (Character.isDigit(currentCh)) {
        num = 10 * num + (currentCh - '0');
      } else if (currentCh == '(') {
        //а вот если это откр скобка то мчим вперед набивая открытые и закрытые скобки
        int j = i + 1;
        int braces = 1;
        for (; j < s.length(); j++) {
          if (s.charAt(j) == '(') {
            ++braces;
          }
          if (s.charAt(j) == ')') {
            --braces;
          }
          if (braces == 0) {
            break;
          }
        }
        //вот тут мы вытащили подстроку с ближайшими закрывающимися скобками
        //(2+6* 3+5-(3*14/7+2)*5)+3 - было так станет вот так 2+6*3+5-(3*14/7+2)*5
        //а потом вот так 3*14/7+2 и мы там уже сумму вернем которая будет в этих скобках
        num = calculate(s.substring(i + 1, j));
        //и вот он самый главный момент в алгоритме то что мы наш указатель i смещаем на j
        //а j это указатель закр скобки
        //таким образом мы уходим за скобку с готовой суммой на руках
        i = j;
      }

      if (currentCh == '+' || currentCh == '-' || currentCh == '*' || currentCh == '/'
          || i == s.length() - 1) {
        switch (prevSign) {
          case '+':
            stack.push(num);
            break;
          case '-':
            stack.push(-num);
            break;
          case '*':
            stack.push(stack.pop() * num);
            break;
          case '/':
            stack.push(stack.pop() / num);
            break;
        }
        num = 0;
        prevSign = currentCh;
      }
    }

    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
  }

}
