package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {


    /**
     * дана строка например : I love beer and my love is big
     * <p>
     * и массив из двух элементов, например (love, big)
     * <p>
     * на выходе хочу получить число 1
     * <p>
     * потому что расстояние между love и bid - одно слово
     * <p>
     * <p>
     * тут есть несколько подходов с мемоизацией - предварительно перевести
     * строку сплитая по пробелам в массив и и закешировать индексы начала
     * каждого слова, затем найти самое короткое расстояние между двумя индексами
     *
     *
     результат мемоизации это мапа с ключом словом, а значением массив индексов где это слово расположено, соотв. в алгоритме поиска первым делом вытащим два массива индексов

     нужно быть очень внимательным при обходе двух массивов с индексами, нужно использовать вычитание по модулю потому что можно получить отрицательное расстояние между элементами в массивах расстояний

     так же очень важный момент, какой индекс двигать i или j
     тут надо включать голову, если мы не достигли концов обоих массивов ТО двигаем индекс тот элемент массива под которым МЕНЬШЕ

     если мы достигли конца одного из массивов то выбора нет двигаем уже оставшийся,

     если достигли конца обоих массивов то все брейк выход из цикла
     */

    static Map<String, List<Integer>> map = new HashMap<>();
    static String str = "I love very much beer and very love fucking fucking fucking beer";

    static {

        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            List<Integer> orDefault = map.getOrDefault(strings[i], new ArrayList<>());
            orDefault.add(i);
            map.put(strings[i], orDefault);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"love", "beer"};
        System.out.println(find(arr));
    }


    static Integer find(String[] arr) {

        String first = arr[0];
        String second = arr[1];

        List<Integer> fArr = map.get(first);
        List<Integer> sArr = map.get(second);


        int i = 0;
        int j = 0;

        int result = Integer.MAX_VALUE;

        while (true) {
            int length = Math.abs(fArr.get(i) - sArr.get(j));
            if (length < result) {
                result = length;
            }
            if (i < fArr.size() - 1 && j < sArr.size() - 1) {
                if (fArr.get(i + 1) < sArr.get(j + 1)) {
                    i++;
                } else {
                    j++;
                }
            } else if (i < fArr.size() - 1) {
                i++;
            } else if (j < sArr.size() - 1) {
                j++;
            } else {
                break;
            }
        }
        return result - 1;
    }
}
