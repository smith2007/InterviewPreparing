package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ZigZagConversion {

    /**
     *
     * дан массив уникальных значение 	int[] arr = {1,7,2,5,6,8,3};
     *
     *
     * надо трансформировать его в зиг-заг вид
     *
     * зиг-заг вид это : a0<a1>a2<a3>a4<a5>a6  и тд
     *
     *
     * первый подход это взять отсортировать массив и тупо свопнуть пары значение начиная с a[1]
     * то есть a1-a2 , a3-a4, a5-a6
     *
     * сложность по времени: О(n log n)
     * сложность по памяти: О(1)
     *
     *
     * есть решение за константное время
     *
     * он состоит в том что бы создать флаг который сигнализирует какое отношение сейчас идет по цепочке
     *
     * так как зиг-заг вид это : a0<a1>a2<a3>a4<a5>a6  то у нас есть цепочка отношение больше меньше,
     *
     * <><><><><>  и тд соотв предположим что < - это true а > это false
     * соответсвенно крутимся в цикле, понимаем какая операция текущая, в зависимости от этого проверяем определенные условия:
     *
     * если flag==true (то есть перед нами операция <) проверяем, а элемент a[i]>a[i+1] если да, свопаем их местами, если нет, то все нормально числа стоят так как нам надо и нашей операции удовлетворяют
     *
     * после выхода меня flag с true на false так как следующая операция должна быть >
     * опять проверка, попадаем в другое условие, опять проверяем удовлетворяют ли два числа той операции которую мы хотим видеть то есть (операция > , проверяем a[i]<a[i+1])  то есть нужен ли своп, если да свопаем и так далее
     *
     * сложность по времени: О(n)
     * сложность по памяти: О(1)
     */
    public static void main(String[] args) {
         int[] arr = {8, 7, 10, 5, 6, 1, 3};
         // a0<a1>a2<a3>a4<a5>a6
        // reverseNLogN(arr);

       // int[] arr = new int[]{4, 3, 7, 8, 6, 2, 1};
        // 3,7,4,8,2,6,1

        reverse(arr);
        //1,3,2,6,5,8,7
        IntStream.of(arr).forEach(System.out::println);
    }

    static void reverse(int[] arr) {
        // Flag true indicates relation "<" is expected,
        // else ">" is expected.  The first expected relation
        // is "<"

        boolean flag = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (flag) {
                /* "<" relation expected */
                /* If we have a situation like A > B > C,
                   we get A > B < C by swapping B and C */
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else /* ">" relation expected */ {
                /* If we have a situation like A < B < C,
                   we get A < C > B by swapping B and C */
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            flag = !flag; /* flip flag */
        }
    }

    static void reverseNLogN(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; ) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            i += 2;
        }
    }
}
