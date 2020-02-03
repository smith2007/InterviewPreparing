package array;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public static void main(String[] args) {

        int[] arr = {-4, -1, 0, 3, 10};

        int[] ints = sortedSquares(arr);
        System.out.println(Arrays.toString(ints));

    }

    static int[] sortedSquares(int[] a) {

        if (a.length == 0) {
            return a;
        }

        int lastNegativeIndex = -1;

        for (int i = 0; i < a.length; i++) {

            if (a[i] < 0) {
                lastNegativeIndex = i;
            }
            a[i] *= a[i];
        }

        if (lastNegativeIndex == -1) {
            return a;
        }

        int[] res = new int[a.length];

        int i = lastNegativeIndex + 1;
        int j = lastNegativeIndex;
        int k = 0;
        while (j >= 0 && i < a.length) {
            if (a[i] < a[j]) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = a[j];
                j--;
            }
            k++;
        }

        while (i < a.length) {
            res[k] = a[i];
            k++;
            i++;
        }

        while (j >= 0) {
            res[k] = a[j];
            j--;
            k++;
        }

        return res;

    }
}
