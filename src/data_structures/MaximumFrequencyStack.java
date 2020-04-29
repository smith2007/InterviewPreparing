package data_structures;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {

  /**
   * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
   * <p>
   * FreqStack has two functions:
   * <p>
   * push(int x), which pushes an integer x onto the stack. pop(), which removes and returns the
   * most frequent element in the stack. If there is a tie for most frequent element, the element
   * closest to the top of the stack is removed and returned.
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
   * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]] Output: [null,null,null,null,null,null,null,5,7,5,4]
   * Explanation: After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.
   * Then:
   * <p>
   * pop() -> returns 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
   * <p>
   * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack
   * becomes [5,7,5,4].
   * <p>
   * pop() -> returns 5. The stack becomes [5,7,4].
   * <p>
   * pop() -> returns 4. The stack becomes [5,7].
   */


  /**
   * Hash map freq will count the frequence of elements.
   * Hash map m is a map of stack.
   * If element x has n frequence, we will push x n times in m[1], m[2] .. m[n]
   * maxfreq records the maximum frequence.
   *
   * push(x) will push x tom[++freq[x]]
   * pop() will pop from the m[maxfreq]
   *
   * решаем через стек стеков, а именно через две мапы
   */
  HashMap<Integer, Integer> elmToFreq = new HashMap<>();
  HashMap<Integer, Stack<Integer>> freqToStack = new HashMap<>();
  int maxFreq = 0;

  public void push(int x) {
    int newFreqForElm = elmToFreq.getOrDefault(x, 0) + 1;
    elmToFreq.put(x, newFreqForElm);

    //обновляем максимальную частоту если надо
    maxFreq = Math.max(maxFreq, newFreqForElm);
    //третий шаг это добавить в нашу вторую мапу
    //новый стек если там такого не было
    if (!freqToStack.containsKey(newFreqForElm)) {
      freqToStack.put(newFreqForElm, new Stack<>());
    }
    //ну и добавляем
    freqToStack.get(newFreqForElm).add(x);
  }

  public int pop() {
    //метод поп
    //берем максималку, попаем из стека
    int x = freqToStack.get(maxFreq).pop();
    elmToFreq.put(x, maxFreq - 1);
    //если стек оказывается пустым, то уменьшаем maxFreq
    if (freqToStack.get(maxFreq).size() == 0) {
      maxFreq--;
    }
    return x;
  }
}

