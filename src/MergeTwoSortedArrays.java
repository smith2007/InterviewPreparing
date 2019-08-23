import java.util.stream.IntStream;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 6, 7};
        int[] arr2 = {0, 1, 3, 9};

        int[] merged = merge(arr1, arr2);

        IntStream.of(merged).forEach(System.out::print);
    }

    static int[] merge(int[] arr1, int[] arr2) {

        int[] arr3 = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;

        }

        if (i == arr1.length) {
            while (j < arr2.length) {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        } else {
            while (i < arr1.length) {
                arr3[k] = arr1[i];
                i++;
                k++;
            }
        }
        return arr3;
    }
}
