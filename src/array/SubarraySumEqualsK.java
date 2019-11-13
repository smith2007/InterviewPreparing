package array;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int k = 3;

        System.out.println(subarraySum(arr, k));
    }

    static int subarraySum(int[] arr, int k) {
        int count = 0;
        int localSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // базовый элемент который даст ноль, то есть это означает что мы его нашли

        for (int elm : arr) {
            localSum += elm; // тут мы тупо считаем сумму всех элементов массива

            // далее берем общую сумму элементов массива на текущем шаге
            // вычитаем наш k
            // если наша сумма массива будет равна и так нашему k
            // то получим ноль
            // и далее в мапе найдем ее все нормально
            // но что если сумма будет больше или меньше
            // то надо понимат а есть ли на прошлом шаге какая либо
            //под сумма которая в итоге даст нужный результат
            int countsFound = localSum - k;

            if (map.containsKey(countsFound)) {
                count += map.get(countsFound);
            }

            //заодно берем и кладем в мапу эту локальную сумму
            map.put(localSum, map.getOrDefault(localSum, 0) + 1);
        }
        return count;
    }
}
