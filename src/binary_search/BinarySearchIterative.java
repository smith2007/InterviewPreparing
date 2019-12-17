package binary_search;

public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr,4));

    }

    static int binarySearch(int[] arr, int elm) {
        int start = 0;
        int end = arr.length - 1;

        while (end >= start) {
            //делим пополам - берем средний элемент
            int mid = (start + end) / 2;

            if (arr[mid] == elm) {
                return mid;
            } else if (arr[mid] > elm) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
