package array;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 6, 3, 11};
        System.out.println(isItPossible(arr));

    }

    /**
     * есть массив на входе {7,2,5,6,3,11} - 7+2+5+3 = 17 и 11+6=17 ответ true, массив пополам делится
     *
     * тут я сам придумал решение, надо сначала посчитать сумму массива, поделить пополам,
     * если четная тогда теоретически это возможно, если нечетное сразу возвращаем false
     *
     *
     * дальше, если четная, то есть теоретически возможно, то надо делать мапу с каунтером,
     * она будет нужна для мемоизации
     *
     * и дальше окно, будем двигать окно добавляя и удаляя элементы каждый раз проверяя
     * встречался ли этот элемент в остальной части массива
     *
     * сложность по времени: О(n)
     * сложность по памяти: О(n)
     */

    static boolean isItPossible(int[] arr) {
        int sum = 0;
        for (int elm : arr) {
            sum += elm;
        }
        if (sum % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int half = sum / 2;
        int localSum = 0;
        while (j < arr.length) {
            if (localSum < half) {
                localSum += arr[j];
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            if (localSum == half) {
                return true;
            }
            if (localSum > half) {
                int needed = localSum - half;
                if (map.containsKey(needed)) {
                    return true;
                } else {
                    int elmi = arr[i];
                    localSum -= elmi;
                    Integer counti = map.get(arr[i]);
                    if (counti - 1 == 0) {
                        map.remove(arr[i]);
                    } else {
                        map.put(arr[i], counti - 1);
                    }
                    i++;
                }

            }

            if (localSum < half) {
                j++;
            }
        }
        return false;
    }


}
