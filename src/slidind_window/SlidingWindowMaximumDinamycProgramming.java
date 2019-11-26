package slidind_window;

import java.util.Arrays;

public class SlidingWindowMaximumDinamycProgramming {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

    static int[] maxSlidingWindow(int[] arr, int k) {

        int n = arr.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return arr;
        }

        int[] left = new int[n];

        left[0] = arr[0];

        int[] right = new int[n];

        right[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {

            // from left to right
            if (i % k == 0) {
                left[i] = arr[i];  // block_start
            } else {
                left[i] = Math.max(left[i - 1], arr[i]);
            }

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = arr[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], arr[j]);
            }
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }
}
