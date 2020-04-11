package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

  public static void main(String[] args) {

  }

  /**
   * работаем по принципу dailytemperatures
   * нагружаем в стек
   * только здесь надо крутится до n*2
   */
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] next = new int[n];
    Arrays.fill(next, -1);
    Stack<Integer> stack = new Stack<>(); // index stack
    //работаем через два прохода
    for (int i = 0; i < n * 2; i++) {
      int elm = nums[i % n];
      //выгребаем из стека все то что меньше нашего текущего элемента
      while (!stack.isEmpty() && nums[stack.peek()] < elm) {
        next[stack.pop()] = elm;
      }
      if (i < n) {
        stack.push(i);
      }
    }
    return next;
  }
}
