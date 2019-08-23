package string;

public class IntMax {


    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 0, 1, 1, 1};

        System.out.println(is(arr));
    }

    static boolean is(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max - 1, arr[i]);
            if (max <= 0) {
                return false;
            }
            if ((i + max) >= arr.length - 1) {
                return true;
            }
        }
        return false;
    }
}
