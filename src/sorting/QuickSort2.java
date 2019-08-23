package sorting;

import java.util.stream.IntStream;

public class QuickSort2 {


    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 8, 4, 2, 7, 2, 0, 1, 9};
        sort(arr);
        IntStream.of(arr).forEach(System.out::print);
    }

    /**
     * Сложность по времени О(n log n)
     * Сложность по памяти О(log n)
     */
    // суть в следующем
    // мы берем pivot он же опорный элемент, наобум
    // и расставляем вокруг него элементы
    // слева элементы меньше пивота
    // справа элементы больше
    static void sort(int[] arr) {

        int begin = 0;
        int end = arr.length - 1;

        sort(arr, begin, end);


    }

    static void sort(int[] arr, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return;
        }

        int pivotIndex = findPivotAndPutAround(arr, beginIndex, endIndex);
        sort(arr, beginIndex, pivotIndex - 1);
        sort(arr, pivotIndex + 1, endIndex);

    }

    // там вроде мы береме и фантомно двигаем
    // меняя затем первый к середине с нашим пивотом который является первый элемент
    static int findPivotAndPutAround(int[] arr, int beginIndex, int endIndex) {
        int pivot = arr[endIndex];
        int newPivotIndex = beginIndex - 1;

        for (int i = beginIndex; i < endIndex; i++) {
            if (arr[i] <= pivot) {
                newPivotIndex++;
                int temp = arr[newPivotIndex];
                arr[newPivotIndex] = arr[i];
                arr[i] = temp;
            }
        }

        newPivotIndex++;
        int temp = arr[newPivotIndex];
        arr[newPivotIndex] = arr[endIndex];
        arr[endIndex] = temp;

        return newPivotIndex;

    }


}
