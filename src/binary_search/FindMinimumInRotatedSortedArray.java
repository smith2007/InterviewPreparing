package binary_search;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(find(arr));
    }

    static int find(int[] arr) {

        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        }

        int start = 0;
        int end = arr.length - 1;

        // loop invariant: 1. low < high
        //                 2. mid != high and thus A[mid] != A[high] (no duplicate exists)
        //                 3. minimum is between [low, high]
        // The proof that the loop will exit: after each iteration either the 'high' decreases
        // or the 'low' increases, so the interval [low, high] will always shrink.
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] > arr[end]) {
                // the mininum is in the right part
                start = mid + 1;
            } else {
                // the mininum is in the left part
                end = mid;
            }
        }

        return arr[start];
    }


}
