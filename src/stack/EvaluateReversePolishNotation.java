package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

  public int evalRPN(String[] arr) {

    //в стек накладываем числа, парами, после того как встретили
    //знак надо эту пару из стека вытащить и выполнить
    //выражение и в стек обратно положить
    Stack<Integer> stack = new Stack<>();
    for (String elm : arr) {
      switch (elm) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          stack.push(-stack.pop() + stack.pop());
          break;

        case "*":
          stack.push(stack.pop() * stack.pop());
          break;

        case "/":
          int n1 = stack.pop(), n2 = stack.pop();
          stack.push(n2 / n1);
          break;

        default:
          stack.push(Integer.parseInt(elm));
      }
    }

    return stack.pop();
  }

}
