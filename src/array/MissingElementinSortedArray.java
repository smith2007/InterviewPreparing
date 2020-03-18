package array;

public class MissingElementinSortedArray {

  public static void main(String[] args) {
    int[] arr = {1, 2, 4};
    System.out.println(missingElement(arr, 3));
  }

  static int missingElement(int[] nums, int k) {

    if (nums.length == 0) {
      return k;
    }
    int kthElement = 0;

    for (int i = 1; i < nums.length; i++) {
      int curr = nums[i - 1];
      int next = nums[i];

      //проверяем что между текущим и сл расстояние 1
      //если нет то апдейтим
      if (next - curr != 1) {
        kthElement = curr + 1;
        k--;

        while (k != 0 && kthElement + 1 != next) {
          k--;
          kthElement++;
        }

        if (k == 0) {
          return kthElement;
        }
      }
    }

    kthElement = nums[nums.length-1];
    while (k != 0) {
      k--;
      kthElement++;
    }

    return kthElement;
  }

}
