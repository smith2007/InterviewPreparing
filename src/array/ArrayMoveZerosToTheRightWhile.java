package array;

import java.util.stream.IntStream;

public class ArrayMoveZerosToTheRightWhile {


    public static void main(String[] args) {
        int[] arr = {4, 0, 1, 2, 0, 2, 6, 0};
        move(arr);
        IntStream.of(arr).forEach(System.out::println);
        //4 1 2 2 6 0 0 0
    }


    static void move(int[] arr) {
        int i = 0, j = 0;
        while (true) {
            if (arr[i] == 0) {
                while (true) {
                    if (arr[j] != 0) {
                        break;
                    } else {
                        j++;
                    }

                    if (j > arr.length - 1) {
                        return;
                    }
                }

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j = i;
            } else {
                i++;
                j++;
            }

            if (j > arr.length - 1) {
                return;
            }

        }
    }

}
