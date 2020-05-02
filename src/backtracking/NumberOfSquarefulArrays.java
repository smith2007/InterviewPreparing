package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfSquarefulArrays {

  /**
   * дан массив  не отричцательных чисел - далее - массив является квадратообразующим если каждая
   * пара смежных элементов - точнее их сумма - является идеальным квадратом
   * <p>
   * <p>
   * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent
   * elements, their sum is a perfect square.
   * <p>
   * Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ
   * if and only if there is some index i such that A1[i] != A2[i].
   * <p>
   * <p>
   * <p>
   * верни кол-во пермутаций массива которые квадратообразующие
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: [1,17,8] Output: 2 Explanation: [1,8,17] and [17,8,1] are the valid permutations.
   * Example 2:
   * <p>
   * Input: [2,2,2] Output: 1
   * <p>
   * <p>
   * Полный квадрат, или квадратное число, — число, являющееся квадратом некоторого целого числа.
   * Иными словами, квадратом является целое число, квадратный корень из которого извлекается
   * нацело. Геометрически такое число может быть представлено в виде площади квадрата с
   * целочисленной стороной.
   * <p>
   * Например, 9 — это квадратное число, так как оно может быть записано в виде 3 × 3, а также
   * представляет площадь квадрата со стороной, равной 3.
   */

  /*
  Avoid duplicate numbers in recursion by sorting Arrays.sort(A);
and use the A[i]==A[i-1] trick while iterating

Before entering another recursion level check to make sure you are forming a square <-- this part I figured out post-contest
   */
  private boolean isSquare(int a, int b) {
    double sqr = Math.sqrt(a + b);
    boolean res = (sqr - Math.floor(sqr)) == 0;
    return res;
  }

  private int count = 0;

  private void helper(List<Integer> temp, int[] arr, boolean[] used, int lastNumber) {
    if (temp.size() == arr.length) {
      count++;
    } else {
      for (int i = 0; i < arr.length; i++) {
        if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
          continue;
        }
        if (lastNumber != -1) {
          // if we cant form a square we can not proceed to form a squareful array
          if (!isSquare(arr[i], lastNumber)) {
            continue;
          }
        }
        used[i] = true;
        temp.add(arr[i]);
        helper(temp, arr, used, arr[i]);
        temp.remove(temp.size() - 1);
        used[i] = false;
      }
    }
  }

  public int numSquarefulPerms(int[] arr) {
    Arrays.sort(arr);
    helper(new ArrayList<>(), arr, new boolean[arr.length], -1);
    return count;
  }
}
