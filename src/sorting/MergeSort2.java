package sorting;

import java.util.stream.IntStream;

public class MergeSort2 {

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 6, 7, 3, 0, 9, 1};

        System.out.println("Before ");
        IntStream.of(arr).forEach(System.out::print);

        sort(arr, 0, arr.length - 1);

        System.out.println();

        System.out.println("After ");
        IntStream.of(arr).forEach(System.out::print);
    }

    /**
     * суть сортировки слиянием заключается в том что
     * массив мы дробим до тех пор пока не получим частный случай - из одного элемента
     * дальше когда получили один элемент
     * делаем мердж с соседним подмассивом так что бы меньший элемент оказался слева
     * а больший справа, например
     */
    static void sort(int[] arr, int start, int end) {

        // тут длинна подмассива ноль или 1
        // частный случай, сортировать не надо
        int subArrLength = 0;
        //тут так хитровыебанно я считаю  дилинну подмассива
        if (start == 0) {
            subArrLength = (start + 1) + end;
        } else {
            subArrLength = end - (start - 1);
        }

        //если длинна подмассива меньше двух
        //то есть один блять
        //все это частный случай, отпусти его, он дальше выше по стеку зайдет в функцию мердж
        if (subArrLength < 2) {
            return;
        }


        int middleIndex = (start + end) / 2; // берем средний элемент

        //вот тут я делаю через подмассивы в общем массиве
        //выглядит как танец с бубном
        // но зато я не создаю третий и четверты ебаный массивы
        int leftArrStartIndex = start;
        int leftArrEndIndex = middleIndex;
        int rightArrStartIndex = middleIndex + 1;
        int rightArrEndIndex = end;

        // делаем сортировку рекурсивно для левой и правой части
        sort(arr, leftArrStartIndex, leftArrEndIndex);
        sort(arr, rightArrStartIndex, rightArrEndIndex);

        merge(arr, leftArrStartIndex, leftArrEndIndex, rightArrStartIndex, rightArrEndIndex);

    }

    static void merge(int[] arr,
                      int leftArrStartIndex,
                      int leftArrEndIndex,
                      int rightArrStartIndex,
                      int rightArrEndIndex) {

        // а вот это блядь самая адовая функция
        //надо смержить два отсортированных массива
        // я это делаю через третий
        int i = leftArrStartIndex;
        int j = rightArrStartIndex;
        int k = 0;

        // так же хитровыебанно считаю длинну левого подмассива
        int leftSubArrLength = 0;
        if (leftArrStartIndex == 0) {
            leftSubArrLength = (leftArrStartIndex + 1) + leftArrEndIndex;
        } else {
            leftSubArrLength = leftArrEndIndex - (leftArrStartIndex - 1);
        }

        // и правого подмассива
        int rightSubArrLength = 0;
        if (rightArrStartIndex == 0) {
            rightSubArrLength = (rightArrStartIndex + 1) + rightArrEndIndex;
        } else {
            rightSubArrLength = rightArrEndIndex - (rightArrStartIndex - 1);
        }

        //это нужно что бы создать третий массив длинна которого будет как сумма длинн
        // первого и второго
        int[] arr3 = new int[leftSubArrLength + rightSubArrLength];

        // ну и тут чо, крутимся в цикле
        // и набиваем третий массив из первых двух
        while (i <= leftArrEndIndex && j <= rightArrEndIndex) {
            if (arr[i] <= arr[j]) {
                arr3[k] = arr[i];
                i++;
            } else {
                arr3[k] = arr[j];
                j++;
            }
            k++;
        }

        //как только достигли конца одного из массивов
        //надо добить второй
        // тут мы смотрим какой именно добить
        if (i > leftArrEndIndex) {
            while (j <= rightArrEndIndex) {
                arr3[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (i <= leftArrEndIndex) {
                arr3[k] = arr[i];
                i++;
                k++;
            }
        }

        //а тут уже финальный этап из третьего копируем в финальный массив
        for (int i1 = leftArrStartIndex, i2 = 0; i1 <= rightArrEndIndex; i1++, i2++) {
            arr[i1] = arr3[i2];
        }
    }
}
