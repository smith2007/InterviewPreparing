package backtracking;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    Идея:
     1. Раскручиваем цикл с право на лево и  ищем первое число, которое нарушает нисходящий порядок.
     2. свопаем это число на наименьшее число, которое больше этого найденного числа.
     3. Выполняем обратную сортировку номеров после обмененного номера.
    */
    static void nextPermutation(int[] arr) {
        // 1. Раскручиваем цикл с право на лево и ищем первое число, которое нарушает нисходящий порядок.
        // 1 2 3 <- идем с конца видим что 2ка < 3ка все - она нарушает нисходящий порядок
        int i = arr.length - 1;
        for (; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                break;
            }
        }

        /* если такое число не нашли, то есть индекс итый дошел до нуля
         * у нас на руках может два кейса
         * - 1ый либо 111111 - значит делать нечего
         * 2ой кейс все числа в убывающем порядке 54321 - значит тупо надо перевернуть массив  */
        if (i == 0) {
            /* для кейса когда у нас длинна массива "1" и элементы там одинаковые "11"
             * делать там нечего сортировать и пермутейтить нечего */
            if (arr.length == 1 || arr[0] == arr[1]) {
                return;
            }
            /* для кейса "54321" просто тупо переворачиваем массив в "12345" */
            int start = i;
            int end = arr.length - 1;
            while (start < end) {
                swap(arr, start++, end--);
            }
        } else {
            //если попали сюда значит нашли такое число которое
            //наш следуюший шаг в этом случае - заменить этот элемент на наименьший элемент,
            // который больше этого найденого на предыдущем шаге элемента.

            // ну собственно как его найти?? бинарный поиск за сложность O(log(arr.length-i))
            // а почему собственно бинарный поиск то?
            // да потому что массив отсортирован
            int j = binarySearchLeastGreater(arr, i, arr.length - 1, arr[i - 1]);

            // если такой элемент есть
            //свопаем с нашим i-1
            if (j != -1) {
                swap(arr, i - 1, j);
            }

            /* и всееее дальше только переворачиваем массив начиная с этого свопа  */
            int start = i;
            int end = arr.length - 1;
            while (start < end) {
                swap(arr, start++, end--);
            }
        }
    }

    static int binarySearchLeastGreater(int[] arr, int start, int end, int key) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
