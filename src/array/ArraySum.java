package array;

import java.util.stream.IntStream;

public class ArraySum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        //6
        System.out.println(sum(arr));
    }

    private static int sum(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }

    private static int sum2(int[] arr){
        return IntStream.of(arr).sum();
    }


}
