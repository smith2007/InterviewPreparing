package dynamic_programming;

public class MaximumSumof3NonOverlappingSubarrays {

  public static void main(String[] args) {

  }

  /**
   * и так идея в том что мы берем окно размером k от самого левого края до самого правого ну и
   * через слайдинг двигаем это окно суммируя и определяем максимум
   */
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int n = nums.length;

    // Get cumulative sum so we know sum of each subarray by O(1).
    //получаем кумулятивную как бы лучшую сумму для каждого индекса
    //для того что бы потом
    int[] sum = new int[n];
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        sum[i] = nums[i];
      } else {
        sum[i] = sum[i - 1] + nums[i];
      }
    }

    // leftVal[i] is the max sum of subarray from nums[0] to nums[i].
    // leftInd[i] is the starting index of the max subarray.
    int[] leftVal = new int[n];
    int[] leftInd = new int[n];
    int tmpMax = 0;
    for (int i = 0; i < k; i++) {
      tmpMax += nums[i];
    }
    leftVal[k - 1] = tmpMax;
    leftInd[k - 1] = 0;
    for (int i = k; i <= n - 1; i++) {
      leftVal[i] = leftVal[i - 1];
      leftInd[i] = leftInd[i - 1];
      int curr = sum[i] - sum[i - k];
      if (curr > tmpMax) {
        tmpMax = curr;
        leftVal[i] = curr;
        leftInd[i] = i - k + 1;
      }
    }

    // rightVal[i] is the max sum of subarray from nums[i] to nums[n - 1].
    // rightInd[i] is the starting index of the max subarray.
    int[] rightVal = new int[n];
    int[] rightInd = new int[n];
    tmpMax = 0;
    for (int i = n - 1; i >= n - k; i--) {
      tmpMax += nums[i];
    }
    rightVal[n - k] = tmpMax;
    rightInd[n - k] = n - k;
    for (int i = n - k - 1; i >= 0; i--) {
      rightVal[i] = rightVal[i + 1];
      rightInd[i] = rightInd[i + 1];
      int curr = i > 0 ? sum[i + k - 1] - sum[i - 1] : sum[i + k - 1];
      if (curr >= tmpMax) {
        tmpMax = curr;
        rightVal[i] = curr;
        rightInd[i] = i;
      }
    }

    // Sliding the window with length k and check the leftVal and rightVal.
    int[] res = new int[3];
    for (int i = k; i + k - 1 < n - k; i++) {
      if (i == k) {
        tmpMax = leftVal[i - 1] + (sum[i + k - 1] - sum[i - 1]) + rightVal[i + k];
        res[0] = leftInd[i - 1];
        res[1] = i;
        res[2] = rightInd[i + k];
      } else {
        int curr = leftVal[i - 1] + (sum[i + k - 1] - sum[i - 1]) + rightVal[i + k];
        if (curr > tmpMax) {
          tmpMax = curr;
          res[0] = leftInd[i - 1];
          res[1] = i;
          res[2] = rightInd[i + k];
        }
      }
    }
    return res;
  }
}
