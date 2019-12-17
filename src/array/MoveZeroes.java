package array;

import java.util.stream.IntStream;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {4, 0, 1, 2, 0, 2, 6, 0};
        move(arr);
        IntStream.of(arr).forEach(System.out::println);
    }

    static void move(int[] arr) {

        //идея тупая до безобразия, и состоит в том что бы тупо идти
        //двумя указателями по массиву и выталкивать нули вперед

        //есть основной индекс - i - он бежит вперед

        //и есть второй индекс который указывает на нулевой элемент

        //а когда элемент не нулевой мы пытаемся делать своп с нулевым
        //соответсвенно мы делаем инкремент этой переменной
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                j++;
            }
        }
    }
}
