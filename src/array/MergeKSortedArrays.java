package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    /**
     * используем так же priority queue так же как и в ситуации с массивом линкедлистов
     * так тут применяем обертку для хранения позиции нашего массива в обромляющем массиве
     * кучу держим всегда размера k, следующий будет добавлен тот элемент который стоит в обертке вытащенного
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 9};
        int[] arr2 = {2, 4, 5};
        int[] arr3 = {3, 6, 10};
        int[] arr4 = {0, 8, 11, 12};

        List<int[]> lists = new ArrayList<>();
        lists.add(arr1);
        lists.add(arr2);
        lists.add(arr3);
        lists.add(arr4);

        List<Integer> result = merge(lists);

        result.forEach(System.out::println);
    }

    static List<Integer> merge(List<int[]> lists) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Elm> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

        for (int i = 0; i < lists.size(); i++) {
            queue.add(new Elm(i, 0, lists.get(i)[0]));
        }

        while (!queue.isEmpty()) {
            Elm elm = queue.poll();
            result.add(elm.value);

            //проверяем есть ли еще элементы в катом массиве
            //что бы если есть, добавить в очередь следующий
            // за только что вытащенным элементом
            if (elm.i + 1 < lists.get(elm.k).length) {
                queue.add(new Elm(elm.k, elm.i + 1, lists.get(elm.k)[elm.i + 1]));
            }
        }

        return result;
    }

    static class Elm {
        int k;
        int i;
        int value;

        public Elm(int k, int i, int value) {
            this.k = k;
            this.i = i;
            this.value = value;
        }
    }
}
