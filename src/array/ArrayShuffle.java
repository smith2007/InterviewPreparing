package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class ArrayShuffle {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};


        ArrayShuffle arrayShuffle = new ArrayShuffle(arr);

        arrayShuffle.reset();
        arrayShuffle.shuffle();


        IntStream.of(arrayShuffle.shuffle()).forEach(System.out::println);

        IntStream.of(arrayShuffle.reset()).forEach(System.out::println);
    }

    private HashMap<Integer, Integer> map = new HashMap<>();

    public ArrayShuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

    }

    /**
     * я взял массив беру каждый иты элемент из него и делаю получение рандома
     * причем учитывая граничные условия, если итый элемент равен 0 или 1 то бери рандом в промежутке справа
     * <p>
     * если итый это последний или предпоследний бери слева,
     * <p>
     * если итый где-то посередине возьми два раза рандом слева в промежутке и справа и брось монетку между ними
     */
    int[] shuffle() {
        int[] arr = reset();
        for (int i = 0; i < arr.length; i++) {
            int newIndex;
            if (i == 0 || i == 1) {
                newIndex = getRandomNumberInRange(i + 1, arr.length - 1);
            } else if (i == arr.length - 1 || i + 1 == arr.length - 1) {
                newIndex = getRandomNumberInRange(0, i - 1);
            } else {
                int first = getRandomNumberInRange(0, i - 1);
                int second = getRandomNumberInRange(i + 1, arr.length - 1);

                int coin = getRandomNumberInRange(0, 1);
                newIndex = coin == 0 ? first : second;
            }

            int temp = arr[newIndex];
            arr[newIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    int[] reset() {
        int[] ints = new int[map.size()];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            ints[entry.getValue()] = entry.getKey();
        }
        return ints;
    }


    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min)) + min;
    }
}
