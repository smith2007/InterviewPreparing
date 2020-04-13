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
   */
  HashMap<Integer, Integer> freq = new HashMap<>();
  HashMap<Integer, Stack<Integer>> map = new HashMap<>();
  int maxfreq = 0;

  public void push(int x) {
    int f = freq.getOrDefault(x, 0) + 1;
    freq.put(x, f);
    maxfreq = Math.max(maxfreq, f);
    if (!map.containsKey(f)) {
      map.put(f, new Stack<>());
    }
    map.get(f).add(x);
  }

  public int pop() {
    int x = map.get(maxfreq).pop();
    freq.put(x, maxfreq - 1);
    if (map.get(maxfreq).size() == 0) {
      maxfreq--;
    }
    return x;
  }
}

