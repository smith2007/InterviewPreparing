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

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return arr[start];
    }


}
