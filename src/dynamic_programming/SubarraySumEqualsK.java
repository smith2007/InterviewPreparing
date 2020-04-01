package dynamic_programming;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] arr = {5, 10, 12, 1, 3, 4, 2, 8};
        int k = 4;

        System.out.println(subarraySum(arr, k));
    }

    /**
     * дан массив и дано число k - {1,2,3} k=3 - найти общее кол-во подмассивов которые в сумме дают k
     *
     *
     * решаем с мемоизацией	через мапу, берем мапу в которой ключ как
     * бы сумма элементов с прошлого шага, а значение это то сколько раз такая сумма встречалась
     * идея в том что мы как бы фиксируем хвост по суммам в виде мапы, так что бы сделать потом k-sum
     */

    static int subarraySum(int[] arr, int k) {
        int count = 0;
        int localSum = 0;

        // берем мапу в которой ключ как
        // бы сумма элементов с прошлого шага, а значение это то сколько раз такая сумма встречалась
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // базовый элемент который даст ноль, то есть это означает что мы его нашли


        //раскручиваем цикл
        //рассматриваем каждый элемент в отдельности
        for (int elm : arr) {
            localSum += elm; // тут мы тупо считаем сумму всех элементов массива

            // далее берем общую сумму элементов массива на текущем шаге
            // вычитаем наш k
            // если наша сумма массива будет равна и так нашему k
            // то получим ноль
            // и далее в мапе найдем ее все нормально
            // но что если сумма будет больше или меньше
            // то надо понимат а есть ли на прошлом шаге какая либо
            //под сумма которая в итоге даст нужный результат???
            int neededSum = localSum - k;

            //если такая подсумма есть - то все зашибись
            if (map.containsKey(neededSum)) {
                count += map.get(neededSum);
            }
            /**
             * были некоторые сложности с понимаением,
             * представь что у нас есть массив int[] arr = {5, 10, 12, 1, 3, 4, 2, 8}; и k=4
             *
             * на каждом этапе локальная сумма у нас будет равна - 5, 15, 27, 28, 31, 35, 37, 45
             * на каждом шаге мы спрашиваем такой вопрос - а есть ли такой элемент
             * в массиве придя в который была бы равна localSum-k ??
             * то есть пришли например в элемент равный 3 - localSum = 31, neededSum=31-4=27
             * есть такой элемент? да есть
             * это значит что начиная с этого элемента есть такой хвост : 1, 3 = который в сумме дает 4
             */

            //заодно берем и кладем в мапу эту локальную сумму
            map.merge(localSum, 1, Integer::sum);
        }
        return count;
    }
}
