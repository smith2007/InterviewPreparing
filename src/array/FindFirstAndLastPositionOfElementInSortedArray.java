package array;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    int[] arr = {1, 4};

    System.out.println(Arrays.toString(searchRange(arr, 4)));
  }

  static int[] searchRange(int[] nums, int target) {
      if (nums.length == 0) {
          return new int[]{-1, -1};
      }
    int[] ans = new int[2];
    ans[0] = findIndex(nums, target, true);
    ans[1] = findIndex(nums, target, false);
    return ans;
  }

  static int findIndex(int[] nums, int target, boolean isLeft) {
    int start = 0;
    int end = nums.length - 1;
    int ans = -1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        ans = mid;
          if (isLeft) {
              end = mid - 1;
          } else {
              start = mid + 1;
          }
      } else if (nums[mid] < target) {
          start = mid + 1;
      } else {
          end = mid - 1;
      }
    }
    return ans;
  }
}
