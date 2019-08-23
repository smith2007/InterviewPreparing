package sorting;

import java.util.stream.IntStream;

public class MergeSort3 {

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 6, 7, 3, 0, 9, 1};

        System.out.println("Before ");
        IntStream.of(arr).forEach(System.out::print);
        System.out.println();
        System.out.println("After");
        int[] result = sort(arr, arr.length);
        IntStream.of(result).forEach(System.out::print);

    }

    static int[] sort(int[] arr, int length) {

        if (length < 2) {
            return arr;
        }
        int mid = length / 2;


        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        left = sort(left, mid);
        right = sort(right, length - mid);
        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] arr3 = new int[left.length + right.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                arr3[k] = left[i];
                i++;
            } else {
                arr3[k] = right[j];
                j++;
            }
            k++;
        }

        if (i == left.length) {
            while (j < right.length) {
                arr3[k] = right[j];
                j++;
                k++;
            }
        } else {
            while (i < left.length) {
                arr3[k] = left[i];
                i++;
                k++;
            }
        }
        return arr3;
    }
}
