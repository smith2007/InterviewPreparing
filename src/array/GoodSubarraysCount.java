package array;

public class GoodSubarraysCount {

  /**
   * Given an array of integers A.
   *
   * A subarray of an array is said to be good if it fulfills any one of the criteria:
   *
   * Length of the subarray must be even and the sum of all the elements of the subarray must be less than B.
   *
   * Length of the subarray must be odd and the sum of all the elements of the subarray must be greater than B.
   *
   * Your task is to find the count of good subarrays in A. If the count of good subarrays exceeds 10^9 then return 10^9.
   *
   * Input Format
   *
   * The first argument given is the integer array A.
   * The second argument given is an integer B.
   * Output Format
   *
   * Return the count of good subarrays in A. If the count of good subarrays exceeds 10^9 then return 10^9.
   * Constraints
   *
   * 1 <= length of the array <= 100000
   * 1 <= A[i] <= 10^4
   * 1 <= B <= 10^9
   * For Example
   *
   * Input 1:
   * A = [1, 2, 3, 4, 5]
   * B = 4
   * Output 1:
   * 6
   * Explanation 1:
   * Even length good subarrays = {1, 2}
   * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
   *
   * Input 2:
   * A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
   * B = 65
   * Output 2:
   * 36
   */
  public int count(int[] arr, int B){
    int[] preSum = new int[arr.length+1];
    int goodCount = 0, currSum  = 0;
    for (int i = 1; i < preSum.length; i++) {
      currSum += arr[i-1];
      preSum[i] = currSum;
    }
    for (int i = 1; i <= arr.length; i++) {
      for (int j = i; j <= arr.length; j++) {
        int subarrSum = preSum[j] - preSum[i-1];
        if((j-i+1) % 2 == 0){
          goodCount +=  (subarrSum < B) ? 1 : 0;
        }
        else{
          goodCount +=  (subarrSum > B) ? 1 : 0;
        }
      }
    }
    return goodCount;
  }

}
