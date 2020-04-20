package binary_search;

public class FindPeakElementRecursive {

    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 2, 1};
        System.out.println(findPeakElement(arr));
    }

    static int findPeakElement(int[] arr) {
        return search(arr, 0, arr.length - 1);
    }

    static int search(int[] arr, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return search(arr, mid + 1, right);
        } else {
            return search(arr, left, mid);
        }
    }
}
