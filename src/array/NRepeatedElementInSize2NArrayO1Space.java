package array;

public class NRepeatedElementInSize2NArrayO1Space {

  /**
   * The idea is simple:
   * We know there is an element - x - that appears N times in array of size 2N.
   * Let us consider the average gap between consecutive x's.
   * Suppose the indexes of all x's is [a1<a2,...<aN]
   * Then the average gap is [(a2-a1)+(a3-a2)+...(aN-a(N-1))] / (N-1)
   * = [aN-a1]/(N-1)<= (2N-1)/(N-1) <= 3
   * Therefor there must exists 2 x's such that their gap is at most 3.
   */
  public int repeatedNTimes(int[] arr) {
    for (int k = 1; k <= 3; k++) {
      for (int i = 0; i < arr.length - k; ++i) {
        if (arr[i] == arr[i + k]) {
          return arr[i];
        }
      }
    }
    return -1;
  }

}
