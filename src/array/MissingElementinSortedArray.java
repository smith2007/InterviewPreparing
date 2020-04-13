package array;

public class MissingElementinSortedArray {

  public static void main(String[] args) {
    int[] arr = {1, 2, 4};
   // System.out.println(missingElement(arr, 3));
  }

  /**
   * итак простой подход здесь заключается в одном проходе через цикл  и два указателя на текущий элемент и на следующий
   * итеративно уменьшаем наш k до тех пор пока k не станет равным нулю как только встречаем разрывы между curr и next подключаем счетчик нашего kthElement++
   *
   *
   * более умный подход заключается в бинарном поиске, мы пользуемся тем что наш массив отсортирован
   * Идея состоит в том, чтобы найти самый левый элемент так, чтобы число пропущенных чисел до тех пор, пока этот элемент не станет меньше или равeн k.
   *
   * алгоритм:
   * * реализуем функцию missing(idx) так что бы она возвращала сколько чисел пропущено до элемента с индексом idx function returns nums[idx] - nums[0] - idx. 
   * //как это понять ?? в чем смысл этой функции
   * //ну например у нас массив {4, 7, 9, 10} сколько тут элементов всего в идеале было бы??
   * //6 элементов - 4 5 6 7 8 9 10
   * //как понять сколько пропущено например для целого массива nums[n-1] - nums[0] - idx = 10 - 4 - 3 = 3
   * // пропущено в массиве 3 элемента 5 6 8
   *
   * * находим индекс так что бы  missing(idx - 1) < k <= missing(idx) ПУТЕМ БИНАРНОГО ПОИСКА 
   * * возвращаем kth smallest nums[idx - 1] + k - missing(idx - 1). 
   */

  /**
   * Let missingNum be amount of missing number in the array. Two cases that need to be handled:
   *
   * missingNum < k, then return nums[n - 1] + k - missingNum
   * missingNum >= k, then use binary search(during the search k will be updated)
   * to find the index in the array, where the kth missing number will be located in (nums[index], nums[index + 1]), return nums[index] + k
   */
  public int missingElement(int[] nums, int k) {
    int n = nums.length;
    int l = 0;
    int h = n - 1;
    int missingNum = nums[n - 1] - nums[0] + 1 - n;

    if (missingNum < k) {
      return nums[n - 1] + k - missingNum;
    }

    while (l < h - 1) {
      int m = l + (h - l) / 2;
      int missing = nums[m] - nums[l] - (m - l);

      if (missing >= k) {
        // when the number is larger than k, then the index won't be located in (m, h]
        h = m;
      } else {
        // when the number is smaller than k, then the index won't be located in [l, m), update k -= missing
        k -= missing;
        l = m;
      }
    }

    return nums[l] + k;
  }

}
