import java.util.stream.IntStream;

public class MergeSort {

    // запомни - любая сортировка не должна возвращать новый массив
    // она должна мутировать текущий
    private static void sort(int[] arr, int arrLength) {
        if (arrLength < 2) { // частный случай, сортировать не надо
            return;
        }
        int middleIndex = arrLength / 2;
        int[] left = new int[middleIndex];
        int[] right = new int[arrLength - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            left[i] = arr[i];
        }
        for (int i = middleIndex; i < arrLength; i++) {
            right[i - middleIndex] = arr[i];
        }
        sort(left, middleIndex);
        sort(right, arrLength - middleIndex);

        merge(arr, left, right, middleIndex, arrLength - middleIndex);
    }


    private static void merge(int[] arr, int[] left, int[] right, int leftIndex, int rightIndex) {
        int i = 0, j = 0, k = 0;

        while (i < leftIndex && j < rightIndex) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < leftIndex) {
            arr[k++] = left[i++];
        }
        while (j < rightIndex) {
            arr[k++] = right[j++];
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 0};

        sort(arr, arr.length);
        IntStream.of(arr).boxed().forEach(System.out::println);

    }
}
