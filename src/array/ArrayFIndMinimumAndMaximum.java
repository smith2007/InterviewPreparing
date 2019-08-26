package array;

public class ArrayFIndMinimumAndMaximum {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 6, 2, 9, 9, 1};
        find(arr);
    }


    private static void find(int[] arr) {

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        for (int elm : arr) {
            if (elm >= maximum) {
                maximum = elm;
            }
            if (elm <= minimum) {
                minimum = elm;
            }
        }

        System.out.println("minimum is " + minimum);
        System.out.println("maximum is " + maximum);

    }
}
