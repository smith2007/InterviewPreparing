package search;

public class FindPeakElementIterative {

    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 2, 1};
        System.out.println(findPeakElement(arr));
    }

    static int findPeakElement(int[] arr) {
        return search(arr, 0, arr.length - 1);
    }

    static int search(int[] arr, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return search(arr, mid + 1, r);
        } else {
            return search(arr, l, mid);
        }
    }
}
