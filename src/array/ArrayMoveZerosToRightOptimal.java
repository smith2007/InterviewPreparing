package array;

import java.util.stream.IntStream;

public class ArrayMoveZerosToRightOptimal {

    public static void main(String[] args) {
        int[] arr = {4, 0, 1, 2, 0, 2, 6, 0};
        move(arr);
        IntStream.of(arr).forEach(System.out::println);
    }

    static void move(int[] arr) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < arr.length; cur++) {
            if (arr[cur] != 0) {
                int temp = arr[lastNonZeroFoundAt];
                arr[lastNonZeroFoundAt] = arr[cur];
                arr[cur] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }
}
