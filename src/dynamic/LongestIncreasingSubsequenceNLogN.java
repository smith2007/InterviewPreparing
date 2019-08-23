package dynamic;


public class LongestIncreasingSubsequenceNLogN {

    /**
     * ищем наиболее часто повторяющуюся возрастающую последовательность
     * в массиве
     * <p>
     * за n Log n
     */
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80, 23, 24, 25, 26, 27, 28};

        System.out.println(findLis(arr, arr.length));

    }

    static int findLis(int[] arr, int size) {

        //создаем темповый массив
        //по дефолту он конечно же заполнен нулями
        //данный темп будет формироваться отсортированным
        int[] temp = new int[size];
        int tempLength; // always points empty slot

        //по дефолту нулевой элемент у нас встает на нулевую позицию
        temp[0] = arr[0];

        //вводим переменную
        //она будет индексом во временном массиве
        tempLength = 1;

        for (int i = 1; i < size; i++) {
            //
            if (arr[i] < temp[0]) {
                // новое минимальное значение,
                // всегда встает в нулевой элемент темп массива
                temp[0] = arr[i];

            } else if (arr[i] > temp[tempLength - 1]) {
                // arr[i] больше чем правая граница,
                // расширяем темп массив и двигаем указатель
                temp[tempLength] = arr[i];
                tempLength++;

            } else {
                // arr[i] надо вставить куда то в сердину существующего сиквенса
                //вопрос куда, на это нам ответит бинарный поиск, взамен какого
                //элемента можно поставить итый элемент

                int i1 = binarySearch(temp, -1, tempLength - 1, arr[i]);
                temp[i1] = arr[i];
            }
        }

        return tempLength;
    }


    // Binary search (note boundaries in the caller)
    // arr[] is ceilIndex in the caller
    static int binarySearch(int[] arr, int left, int right, int key) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                right = mid;
            } else if (arr[mid] > key) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }


}
