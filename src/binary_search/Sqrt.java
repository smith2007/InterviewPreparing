package binary_search;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }

    static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int end = Integer.MAX_VALUE;

        while (true) {
            int mid = start + (end - start) / 2;

            if (mid > x / mid) {
                end = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                start = mid + 1;
            }
        }
    }
}



