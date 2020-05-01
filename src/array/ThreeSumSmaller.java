package array;

import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {

  /**
   * более умный способ - два указателя - слева и справа они как бы сжимаются
   *
   * квадратичное решение
   */
  public int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);
    int sum = 0;
    // начинаем с каждого итого элемента - это будет наш первый элемент
    for (int i = 0; i < nums.length - 2; i++) {
      sum += twoSumSmaller(nums, i + 1, target - nums[i]);
    }
    return sum;
  }

  // ну а тут два указателя слева и справа они сжимаются в попытке найти
  //все варианты что будут меньше нашего таргета
  private int twoSumSmaller(int[] nums, int startIndex, int target) {
    int sum = 0;
    int left = startIndex;
    int right = nums.length - 1;
    while (left < right) {
      if (nums[left] + nums[right] < target) {
        sum += right - left;
        left++;
      } else {
        right--;
      }
    }
    return sum;
  }
}
