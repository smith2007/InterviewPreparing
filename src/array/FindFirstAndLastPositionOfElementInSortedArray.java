package array;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 4};

        System.out.println(Arrays.toString(searchRange(arr, 4)));
    }

    static int[] searchRange(int[] arr, int target) {
        int[] res = new int[2];
        if (arr.length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        if (arr.length == 1 && target == arr[0]) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {

                int i = mid - 1;
                int j = mid + 1;

                while (true) {
                    if (i >= 0 && arr[i] == target) {
                        i--;
                    }

                    if (j <= arr.length - 1 && arr[j] == target) {
                        j++;
                    }

                    if ((i == -1 || arr[i] != target) && (j == arr.length || arr[j] != target)) {
                        break;
                    }
                }

                res[0] = i + 1;
                res[1] = j - 1;
                return res;

            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;
    }
}
