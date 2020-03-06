package math;

import java.util.function.BiFunction;

public class BasicCalculatorIILinkedList {

  public static void main(String[] args) {
    System.out.println(calc("5+2*3+4"));
  }

  static int calc(String str) {
    if (str == null) {
      return -1;
    }

    CalcNode root = null;
    CalcNode curr = root;
    CalcNode prev = null;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (Character.isDigit(c)) {
        Character oper = i != str.length() - 1 ? str.charAt(i + 1) : null;
        if (oper != null) {
          curr = new CalcNode(Character.getNumericValue(c),
              oper == '*' ? Operation.MULT : Operation.ADD, null);
        } else {
          curr = new CalcNode(Character.getNumericValue(c),
              null, null);
        }
        if (root == null) {
          root = curr;
        }
        if (prev != null) {
          prev.next = curr;
        }
        prev = curr;
      }
    }
    CalcNode newRoot = process(root, Operation.MULT);
    return processAdd(newRoot);

  }

  static CalcNode process(CalcNode root, Operation operation) {
    CalcNode curr = root;
    CalcNode prev = null;

    while (curr.next != null) {
      if (curr.operation == operation) {
        CalcNode newNode = new CalcNode(operation.func.apply(curr.val, curr.next.val),
            curr.next.operation, curr.next.next);
        if (prev != null) {
          prev.next = newNode;
        }
        curr = newNode;
      } else {
        prev = curr;
        curr = curr.next;
      }
    }
    return root;
  }

  static int processAdd(CalcNode root) {
    CalcNode curr = root;
    int coll = 0;
    while (curr != null) {
      coll += curr.val;
      curr = curr.next;
    }
    return coll;
  }


  static class CalcNode {

    int val;
    Operation operation;
    CalcNode next;

    public CalcNode(int val, Operation operation, CalcNode next) {
      this.val = val;
      this.operation = operation;
      this.next = next;
    }
  }

  enum Operation {
    MULT((integer, integer2) -> integer * integer2),
    ADD(Integer::sum);

    private BiFunction<Integer, Integer, Integer> func;

    Operation(BiFunction<Integer, Integer, Integer> func) {
      this.func = func;
    }
  }

}
