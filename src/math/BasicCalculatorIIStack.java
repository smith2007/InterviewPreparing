package math;

import java.util.Stack;

public class BasicCalculatorIIStack {

  /**
   * этот подход даже еще проще чем с темп самом и локал самом просто мы накладываем в стек наши
   * последние числа которые потом сложим
   * <p>
   * если перед нами операция умножения или деления, то есть более приоритетная операция то надо
   * последнее число попнуть - умножить и опять положить на стек
   */
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    //накладываем на стек числа
    //которые в дальнейшем проссумируем
    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char previousSign = '+';

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      //если это число то крутимся и набиваем разяряды числа
      if (Character.isDigit(current)) {
        num = 10 * num + (current - '0');
      }

      //если это операция тогда надо сделать действие с последним числом
      if (current == '+' || current == '-' || current == '*' || current == '/'
          || i == s.length() - 1) {
        //в зависимости от предыдущего знака
        switch (previousSign) {
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
        previousSign = current;
      }
    }

    int result = 0;
    //теперь просто суммируем
    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    return result;
  }
}
