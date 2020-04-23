package array;

public class FindPivotIndex {

  /**
   * надо посчитать кумулятивную сумму,
   * затем идти по массив набивать вторую сумму и вычитать из глобальной, как только нашли - возвращаем
   */
  public int pivotIndex(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int leftsum = 0;

    for (int i = 0; i < nums.length; ++i) {
      if (leftsum == sum - leftsum - nums[i]) {
        return i;
      }
      leftsum += nums[i];
    }
    return -1;
  }

}
