package sorting;

public class SortColors {

  public static void main(String[] args) {

    int[] arr = {2, 0, 1};

    sortColors(arr);

    for (int value : arr) {
      System.out.println(value);
    }
  }

  static void sortColors(int[] arr) {
    if (arr.length == 0) {
      return;
    }

    int start = 0;
    for (; start < arr.length; start++) {
      if (arr[start] != 0) {
        break;
      }
    }

    int end = arr.length - 1;

    for (; end >= 0; end--) {
      if (arr[end] != 2) {
        break;
      }
    }

    while (start <= end) {

      if (arr[start] == 2) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
      }

      for (; start < arr.length; start++) {
        if (arr[start] != 0) {
          break;
        }
      }

      for (; end >= 0; end--) {
        if (arr[end] != 2) {
          break;
        }
      }

      if (arr[start] == arr[end]) {
        break;
      }
    }

  }

}
