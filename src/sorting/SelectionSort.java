package sorting;

import java.util.stream.IntStream;

public class SelectionSort {

    public static void main(String[] args) {

        int[] array = {1, 6, 2, 8, 4, 9,};

        int[] sorted = sort(array);

        IntStream.of(sorted).forEach(System.out::print);

    }


    /**
     * так еще раз в чем идея - идея в том что есть массив который надо отсортировать
     * для этого мы создаем новый массив и наполняем его каждый раз максимальным элементом из главного
     * каждый раз найдя новый максимальный элемент и вставив его в новый отсортированный массив
     * в старом массиве мы вычеркиваем и начинаем цикл заново
     */
    static int[] sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int tempIndex = -1;
        int lastMaxIndex = -1;

        // так как сложность квадратичная, запускаем два цикла
        for (int i = 0; i < arr.length; i++) {
            // и каждый раз находим новый максиму
            for (int j = tempIndex + 1; j < arr.length; j++) {
                if (arr[j] >= max) {
                    max = arr[j];
                    lastMaxIndex = j;
                }
            }
            //как только нашли запоминаем его индекс и его самого
            // и дальше тупо свопаем с первым (или последующими) индексами
            int temp = arr[tempIndex + 1];
            arr[tempIndex + 1] = arr[lastMaxIndex];
            arr[lastMaxIndex] = temp;
            tempIndex++;
            max = Integer.MIN_VALUE;
        }

        return arr;

    }
}
