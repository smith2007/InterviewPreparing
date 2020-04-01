package array;

public class MonotonicArray {

    public boolean isMonotonic(int[] arr) {

        if (arr.length < 2) {
            return true;
        }

        if (arr[0] < arr[arr.length - 1]) {
            int prev = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int cur = arr[i];
                if (cur < prev) {
                    return false;
                }
                prev = cur;
            }
        } else {
            int prev = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int cur = arr[i];
                if (cur > prev) {
                    return false;
                }
                prev = cur;
            }
        }
        return true;
    }
}
