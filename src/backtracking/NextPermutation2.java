package backtracking;

import java.util.Arrays;

public class NextPermutation2 {

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr) {
        int i = arr.length - 1;
        for (; i >= 1; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            if (arr.length == 1 || arr[i] == arr[i + 1]) {
                return;
            }

            int i1 = i;
            int i2 = arr.length - 1;
            while (i1 < i2) {
                swap(arr, i1, i2);
                i1++;
                i2--;
            }

        } else {

            //надо найти минимальный близкий к i-1
            int j = binarySearch(arr, i, arr.length - 1, arr[i - 1]);

            if (j != -1) {
                swap(arr, i - 1, j);
            }

            int i1 = i;
            int i2 = arr.length - 1;
            while (i1 < i2) {
                swap(arr, i1, i2);
                i1++;
                i2--;
            }
        }

    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int binarySearch(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start+(end-start) / 2;
           if (arr[mid] > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
