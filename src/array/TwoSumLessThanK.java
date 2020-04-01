package array;

import java.util.Arrays;

public class TwoSumLessThanK {

  public static void main(String[] args) {

  }

  public int twoSumLessThanK(int[] a, int k) {
    Arrays.sort(a); // Time cost O(nlogn).
    int max = -1, i = 0, j = a.length - 1;
    while (i < j) {
      int sum = a[i] + a[j];
      if (sum < k) { // find one candidate.
        max = Math.max(max, sum);
        ++i; // increase the smaller element.
      }else { // >= sum.
        --j; // decrease the bigger element.
      }
    }
    return max;
  }

}
