package array;

import java.util.stream.IntStream;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int[] product = getProduct(arr);
        IntStream.of(product).forEach(System.out::println);
    }

    static int[] getProduct(int[] arr) {
        int[] result = new int[arr.length];

        result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        // тут интересный фокус получается конечно,
        // надо набить фантомный массив который всегда начинается с 1
        // далее надо использовать этот массив для того что бы перемножать
        // с темповым элементом который получается произведением с предыдущего шага

        int temp = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] = result[i] * temp;
            temp = temp * arr[i];
        }

        return result;
    }
}
