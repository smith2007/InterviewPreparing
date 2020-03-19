package array;

public class MissingElementinSortedArrayBinarySearch {

  public static void main(String[] args) {
    int[] arr = {4, 7, 9, 10};
    System.out.println(missingElement(arr, 12));
  }

  //реализуем функцию missing(idx) так что бы она возвращала сколько чисел пропущено до элемента
  // с индексом idx function
  static int missing(int idx, int[] nums) {
    //как это понять ??
    //ну например у нас массив {4, 7, 9, 10} сколько тут элементов всего в идеале было бы??
    //6 элементов - 4 5 6 7 8 9 10
    //как понять сколько пропущено например для целого массива nums[n-1] - nums[0] - idx = 10 - 4 - 3 = 3
    // пропущено в массиве 3 элемента 5 6 8
    return nums[idx] - nums[0] - idx;
  }

  static int missingElement(int[] nums, int k) {
    int n = nums.length;
    //если катый пропущенный номер больше чем последний элемент массива
    //тогда просто к последнему прибавляем k
    if (k > missing(n - 1, nums)) {
      return nums[n - 1] + k - missing(n - 1, nums);
    }

    int left = 0, right = n - 1, pivot;
    //необходимо найти левый / правый индекс так что бы
    //missing(left - 1) < k <= missing(left)
    while (left != right) {
      pivot = left + (right - left) / 2;

      if (missing(pivot, nums) < k) {
        left = pivot + 1;
      } else {
        right = pivot;
      }
    }

    //катый пропущенный он больше чем nums[idx - 1]
    //и меньше чем nums[idx]
    return nums[left - 1] + k - missing(left - 1, nums);
  }
}
