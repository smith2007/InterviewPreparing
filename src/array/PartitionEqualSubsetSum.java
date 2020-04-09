package array;

import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = {23, 13, 11, 7, 6, 5, 5};
        System.out.println(isItPossible(arr));

    }

    /**
     * задача
     * Вернуть boolean, можно ли разделить массив на две равные части по сумме
     *
     * есть массив на входе {7,2,5,6,3,11} - 7+2+5+3 = 17 и 11+6=17 ответ true, массив пополам делится
     * <p>
     * тут я сам придумал решение, надо сначала посчитать сумму массива, поделить пополам,
     * если четная тогда теоретически это возможно, если нечетное сразу возвращаем false
     * <p>
     * <p>
     * дальше, если четная, то есть теоретически возможно, то надо делать мапу с каунтером,
     * она будет нужна для мемоизации
     * <p>
     * и дальше окно, будем двигать окно добавляя и удаляя элементы каждый раз проверяя
     * встречался ли этот элемент в остальной части массива
     * <p>
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
            //крутимся в цикле
            //набиваем мапу пройденых символов
            if (localSum < half) {
                localSum += arr[j];
                map.merge(arr[j], 1, Integer::sum);
            }

            //если докрутились до того что локальная сумма равна половине
            //все окей
            if (localSum == half) {
                return true;
            }

            //если же больше, то возможно нам надо
            //удалить какой либо элемент
            //что бы получилась половина
            if (localSum > half) {

                //ищем есть ли элемент который можно удалить
                int needed = localSum - half;
                if (map.containsKey(needed)) {
                    //если такой элемент есть то как бы удаляем его и все окей
                    return true;
                } else {

                    //если же такого элемента нет
                    //двигаем второй указатель
                    //итый и удаляем слева элементы
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
